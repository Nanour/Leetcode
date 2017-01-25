// Sourse : https://leetcode.com/problems/longest-valid-parentheses/
// Date   : 2017-01-11

/***********************************************************************
 *
 * Given a string containing just the characters '(' and ')', find the 
 * length of the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 *
 **********************************************************************/

// start表示invalid时，起始’)‘的位置，stk.peek()实际上是invalid时，起始'('的位置
// 遇到'(' push，遇到’)‘先check是否stack为空，如果为空，更新start的boundary值，如果不为空
// 先pop一个，pop之后为空，说明从start到此时都为valid，即i-start；如果不为空，说明有多余’(‘,即i-peek()
// 注意i-boundary中是boundary为开区间

//O(n)
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int start = -1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') {
                stack.push(i);   
            } else if (s.charAt(i) == ')' && !stack.isEmpty()){
                stack.pop();
                if (stack.isEmpty()) {
                    max = Math.max(max,i-start);
                } else {
                    max = Math.max(max,i-stack.peek());
                }
            } else {
                start = i;               
            }
        }
        return max;
    }
}