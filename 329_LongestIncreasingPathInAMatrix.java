// Sourse : https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
// Date   : 2016-11-24

/***********************************************************************
 *
 * Given an integer matrix, find the length of the longest increasing path.
 * 
 * From each cell, you can either move to four directions: left, right, up or 
 * down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 *
 **********************************************************************/

// 每次将计算过的点的最长升序子序列记录在cache[][]中， 避免重复计算

public class Solution {
    public static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, cache);
                max = Math.max(max, len);
            }
        }   
        return max;
    }
    
    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if(cache[i][j] != 0) return cache[i][j];
        int m = matrix.length, n = matrix[0].length, max = 1;
        for(int[] dir: DIRS) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, cache);
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }
}