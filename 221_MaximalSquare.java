// Sourse : https://leetcode.com/problems/maximal-square/
// Date   : 2016-10-19

/***********************************************************************
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * 
 * For example, given the following matrix:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 *
 **********************************************************************/

// O(n^2) time, O(n) space 10ms

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix == null) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] square = new int[n+1];
        int res = 0, pre = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int temp = square[j];
                if (matrix[i-1][j-1] == '1') {
                    square[j] = Math.min(Math.min(square[j], square[j-1]), pre) + 1;
                } else {
                    square[j] = 0;
                }
                res = square[j] > res ? square[j] : res;
                pre = temp;
            }
        }
        return res * res;
    }
}

// O(n^2) time, O(n^2) space 9ms

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix == null) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] square = new int[m+1][n+1];
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1') {
                    square[i][j] = Math.min(Math.min(square[i-1][j], square[i][j-1]), square[i-1][j-1]) + 1;
                } else {
                    square[i][j] = 0;
                }
                res = square[i][j] > res ? square[i][j] : res;
            }
        }
        return res * res;
    }
}


// O(n^2) time, O(3 * n^2) space 15ms
// three array, square/top/left

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix == null) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] top = new int[m+1][n+1];
        int[] left = new int[n+1];
        int[][] square = new int[m+1][n+1];
        int res = 0;
        square[0][0] = 0;
        top[0][0] = 0;
        left[0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1') {
                    square[i][j] = Math.min(Math.min(top[i-1][j], left[j-1]), square[i-1][j-1]) + 1;
                    top[i][j] = top[i-1][j] + 1;
                    left[j] = left[j-1] + 1;
                } else {
                    square[i][j] = 0;
                    top[i][j] = 0;
                    left[j] = 0;
                }
                res = square[i][j] > res ? square[i][j] : res;
            }
        }
        return res * res;
    }
}