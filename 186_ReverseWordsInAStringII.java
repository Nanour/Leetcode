// Sourse : https://leetcode.com/problems/strobogrammatic-number-ii/
// Date   : 2016-11-21

/***********************************************************************
 *
 * Given an input string, reverse the string word by word. A word is defined as 
 * a sequence of non-space characters.
 * 
 * The input string does not contain leading or trailing spaces and the words 
 * are always separated by a single space.
 * 
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the". 
 *
 * Could you do it in-place without allocating extra space?
 * 
 **********************************************************************/

// reverse the whole sequence, and then reverse each word.
public class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        for(int i = 0, j = 0;i <= s.length;i++){
			if(i==s.length || s[i] == ' '){
				reverse(s,j,i-1);
				j = i+1;
			}
		}
    }
    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}