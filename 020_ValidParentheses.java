// Sourse : https://leetcode.com/problems/valid-parentheses/
// Date   : 2016-12-30

/***********************************************************************
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 **********************************************************************/


// check差
public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0)
            return true;
        if(s.length() % 2 == 1)
            return false;
        Stack<Character> stk = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(stk.isEmpty())
                stk.push(s.charAt(i));
            else if(stk.peek() - s.charAt(i) == -1 || stk.peek() - s.charAt(i) == -2)
                stk.pop();
            else
                stk.push(s.charAt(i));
        }
        return stk.isEmpty();
    }
}


// 都check
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        // Iterate through string until empty
        for(int i = 0; i<s.length(); i++) {
            // Push any open parentheses onto stack
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            // Check stack for corresponding closing parentheses, false if not valid
            else if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(')
                stack.pop();
            else if(s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[')
                stack.pop();
            else if(s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{')
                stack.pop();
            else
                return false;
        }
        // return true if no open parentheses left in stack
        return stack.empty();
    }
}