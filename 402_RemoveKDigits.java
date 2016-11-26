// Sourse : https://leetcode.com/problems/remove-k-digits/
// Date   : 2016-11-25

/***********************************************************************
 *
 * Given a non-negative integer num represented as a string, remove k digits 
 * from the number so that the new number is the smallest possible.
 * 
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 *
 **********************************************************************/

public class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == 0 || num.length() == k) return "0";
        Stack<Character> stk = new Stack<>();
        int i = 0;
        while (i < num.length()) { 
            while (k > 0 && !stk.isEmpty() && num.charAt(i) < stk.peek()) {    // 如果当前字符比前面一个小，discard前面的
                stk.pop();
                k--;
            }
            stk.push(num.charAt(i++));
        }
        while (k > 0) {
            stk.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty())
            sb.append(stk.pop());
        sb.reverse();
        
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}