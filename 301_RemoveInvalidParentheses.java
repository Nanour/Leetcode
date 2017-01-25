// Sourse : https://leetcode.com/problems/remove-invalid-parentheses/
// Date   : 2016-11-29

/***********************************************************************
 *
 * Remove the minimum number of invalid parentheses in order to make the 
 * input string valid. Return all possible results.
 * 
 * Note: The input string may contain letters other than the parentheses ( and ).
 * 
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 **********************************************************************/

// 正序删一遍多余的')'， 逆序删一边多余的'('
// 每次删除都是必要的删除，所以得到的是最少的删除次数的string
// 为避免重复，每次记录上一次remove '(' or ')' 的位置，下一次在这之后删除
// 当出现"())" 时，规定删除第一个')'以避免重复，因为此时删除任意一个')'都得到同样的结果"()"


public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        remove(s, res, 0, 0, new char[] {'(', ')'});
        return res;
    }
    private void remove(String s, List<String> res, int last_index, int last_remove, char[] parentheses) {
        for (int count = 0, i = last_index; i < s.length(); i++) {
            if (s.charAt(i) == parentheses[0]) count++;
            if (s.charAt(i) == parentheses[1]) count--;
            if (count >= 0) continue;
            for (int j = last_remove; j <= i; j++) {
                if (s.charAt(j) == parentheses[1] && (j == last_remove || s.charAt(j-1) != parentheses[1])) {
                    remove(s.substring(0, j) + s.substring(j+1, s.length()), res, i, j, parentheses);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (parentheses[0] == '(') {
            remove(reversed, res, 0, 0, new char[] {')', '('});
        } else {
            res.add(reversed);
        }
    }
}