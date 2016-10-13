// Sourse : https://leetcode.com/problems/generate-parentheses/
// Date   : 2016-10-12

/***********************************************************************
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 *  "((()))",
 *  "(()())",
 *  "(())()",
 *  "()(())",
 *  "()()()"
 * ]
 *
 **********************************************************************/

// left represents the number of '(' while right represents the number of ')'
// 初始时 left 为 n， right 为 0
// 插入一个左括号，下一个为dfs(left-1，right+1)
// 插入一个右括号，下一个为dfs(left, right-1) 


public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        backtracking(res, "", n, 0);
        return res;
    }
    private void backtracking(List<String> res, String str, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(str);
            return ;
        }
        if (left > 0) {
            backtracking(res, str+"(", left-1, right+1);
        }
        if (right > 0) {
            backtracking(res, str+")", left, right-1);
        }
    }
}