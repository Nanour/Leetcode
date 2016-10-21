// Sourse : https://leetcode.com/problems/edit-distance/
// Date   : 2016-10-20

/***********************************************************************
 *
 * Given two words word1 and word2, find the minimum number of steps required 
 *　to convert word1 to word2. (each operation is counted as 1 step.)
　*　You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 *
 **********************************************************************/
// https://discuss.leetcode.com/topic/17639/20ms-detailed-explained-c-solutions-o-n-space
// dp[i][j] 指 word1 的 i-1 match word2 的 j-1
// 如果不match：
//	-> replace dp[i][j] = dp[i-1][j-1]+1
//  -> delete dp[i][j] = dp[i-1][j]+1
//  -> insert dp[i][j] = dp[i][j] + 1

public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) != word2.charAt(j-1)) {
                    dp[i][j] = Math.min(dp[i-1][j-1]+1, Math.min(dp[i-1][j]+1, dp[i][j-1]+1));
                } else {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
}