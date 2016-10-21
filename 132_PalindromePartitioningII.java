// Sourse : https://leetcode.com/problems/palindrome-partitioning-ii/
// Date   : 2016-10-20

/***********************************************************************
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 **********************************************************************/

// 不要被palindrome partitioning I 迷惑！！
// 不是backtracking不是记忆化搜索，pure DP！！
// PS backtracking count min size 会超时

// cut[i] 表示到i的最小cut数
// isPalindrome[j][i] 表示j到i是否为palindrome
// 如果ji相邻相同或者他们之间的子串为palindrome，则j到i为palindrome，更新min值

public class Solution {
    public int minCut(String s) {
        int n = s.length();
        char[] str = s.toCharArray();
        boolean[][] isPalindrome = new boolean[n][n];
        int[] cut = new int[n];
        int min = 0;
        for (int i = 0; i < n; i++) {
            min = i;
            for (int j = 0; j <= i; j++) {
                if (str[i] == str[j] && (j+1 > i-1 || isPalindrome[j+1][i-1])) {
                    isPalindrome[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j-1]+1);
                }
            }
            cut[i] = min;
        }
        return cut[n-1];
    }
}
