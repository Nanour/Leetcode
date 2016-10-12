// Sourse : https://leetcode.com/problems/evaluate-reverse-polish-notation/
// Date   : 2016-10-10

/***********************************************************************
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 **********************************************************************/

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stk = new Stack<String>();
        int res = 0;
        for (String token : tokens) {
            if ((token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) && stk.size() >= 2) {
                int first = Integer.valueOf(stk.pop());
                int second = Integer.valueOf(stk.pop());
                switch(token.charAt(0)) {
                    case '+': res = second+first; break;
                    case '-': res = second-first; break;
                    case '*': res = second*first; break;
                    case '/': res = second/first; break;
                }
                stk.push(Integer.toString(res));
            } else {
                stk.push(token);
                res = Integer.valueOf(token);
            }
        }
        return res;
    }
}