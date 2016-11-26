// Sourse : https://leetcode.com/problems/expression-add-operators/
// Date   : 2016-11-25

/***********************************************************************
 *
 * Given a string that contains only digits 0-9 and a target value, return 
 * all possibilities to add binary operators (not unary) +, -, or * between 
 * the digits so they evaluate to the target value.
 * 
 * Examples: 
 * "123", 6 -> ["1+2+3", "1*2*3"] 
 * "232", 8 -> ["2*3+2", "2+3*2"]
 * "105", 5 -> ["1*0+5","10-5"]
 * "00", 0 -> ["0+0", "0-0", "0*0"]
 * "3456237490", 9191 -> []
 *
 **********************************************************************/

// 1. overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
// 2. 0 sequence: because we can't have numbers with multiple digits started with zero, we have to deal with it too.
// 3. a little trick is that we should save the value that is to be multiplied in the next recursion.

// with String 282ms
// with StringBuilder 171ms

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        if(num == null || num.length() == 0) return res;
        backtracking(res, new StringBuilder(), num, target, 0, 0, 0);
        return res;
    }
    private void backtracking(List<String> res, StringBuilder path, String num, int target, int pos, long eval, long pre) {
        if (pos == num.length()) {
            if (eval == target) {
                res.add(path.toString());
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (num.charAt(pos) == '0' && i != pos) break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            int len = path.length();
            if (pos == 0) {
                backtracking(res, path.append(cur), num, target, i+1, cur, cur);
                path.setLength(len);
            } else {
                backtracking(res, path.append("+").append(cur), num, target, i+1, eval+cur, cur);
                path.setLength(len);
                backtracking(res, path.append("-").append(cur), num, target, i+1, eval-cur, -cur);
                path.setLength(len);
                backtracking(res, path.append("*").append(cur), num, target, i+1, eval-pre+(pre*cur), pre*cur); 
                path.setLength(len);
            }
        }
    }
}