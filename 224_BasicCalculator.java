// Sourse : https://leetcode.com/problems/basic-calculator/
// Date   : 2016-11-07

/***********************************************************************
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), 
 * the plus + or minus sign -, non-negative integers and empty spaces .
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 *
 ***********************************************************************/

public class Solution {
    public int calculate(String s) {
        int len = s.length(), sign = 1, result = 0;
        Stack<Integer> stk = new Stack<Integer>();
	    for (int i = 0; i < len; i++) {
	        if (Character.isDigit(s.charAt(i))) {
	            int sum = s.charAt(i) - '0';
    			while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
    				sum = sum * 10 + (s.charAt(i + 1) - '0');
    				i++;
    			}
    			result += sum * sign;
	        } else if (s.charAt(i) == '+') {
	            sign = 1;
	        } else if (s.charAt(i) == '-') {
	            sign = -1;
	        } else if (s.charAt(i) == '(') {
	            stk.push(result);
	            stk.push(sign);
	            result = 0;
	            sign = 1;
	        } else if (s.charAt(i) == ')') {
	            result = result * stk.pop() + stk.pop();
	        }
	    }
	    return result;
    }
}