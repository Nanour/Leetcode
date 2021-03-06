// Sourse : https://leetcode.com/problems/is-subsequence/
// Date   : 2016-11-01

/***********************************************************************
 *
 * Given a string s and a string t, check if s is subsequence of t.
 * 
 * You may assume that there is only lower case English letters in both s and t. 
 * t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * 
 * A subsequence of a string is a new string which is formed from the original string by 
 * deleting some (can be none) of the characters without disturbing the relative positions of 
 * the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 *
 **********************************************************************/

public class Solution {
    public boolean isSubsequence(String s, String t) {
        if(t.length() < s.length()) return false;
        int prev = 0;
        for(int i = 0; i < s.length();i++) {
            char tempChar = s.charAt(i);
            prev = t.indexOf(tempChar,prev);
            if(prev == -1) return false;
            prev++;
        }
        return true;
    }
}