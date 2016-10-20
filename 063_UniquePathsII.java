// Sourse : https://leetcode.com/problems/unique-paths-ii/
// Date   : 2016-10-19

/***********************************************************************
 *
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 *  [0,0,0],
 *  [0,1,0],
 *  [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 *
 **********************************************************************/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            res[i][0] = (obstacleGrid[i][0] == 1 || (i > 0 && res[i-1][0] == 0)) ? 0 : 1;
        }
        for (int j = 0; j < n; j++) {
            res[0][j] = (obstacleGrid[0][j] == 1 || (j > 0 && res[0][j-1] == 0)) ? 0 : 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = obstacleGrid[i][j] == 1 ? 0 : res[i-1][j] + res[i][j-1];
            }
        }
        return res[m-1][n-1];
    }
}