// Sourse : https://leetcode.com/problems/regular-expression-matching/
// Date   : 2016-10-04 

/***********************************************************************
 *
 * Implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 *
 **********************************************************************/

// DP 
// dp[i][j] stands for whether s[0...i-1] matches p[0...j-1]
// base: dp[0][0] = true, dp[i][0] = false, dp[0][j] = true iff p[j-1] == '*' && dp[0][j-2] == true
// return: dp[i][j]

public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = false;
        }
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i-1) == '*' && dp[0][i-2]) {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1) != '*') {
                    dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.');
                } else if (p.charAt(j-1) == '*') {
                    dp[i][j] = (dp[i-1][j] && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.')) || dp[i][j-2];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
