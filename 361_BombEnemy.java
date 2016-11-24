// Sourse : https://leetcode.com/problems/bomb-enemy/
// Date   : 2016-11-23

/***********************************************************************
 *
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' 
 * (the number zero), return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted 
 * point until it hits the wall since the wall is too strong to be destroyed.
 * Note that you can only put the bomb at an empty cell.
 * 
 * Example:
 * For the given grid
 * 
 * 0 E 0 0
 * E 0 W E
 * 0 E 0 0
 * 
 * return 3. (Placing a bomb at (1,1) kills 3 enemies)
 *
 ***********************************************************************/

// DP
// O(mn)
// rowHit 记录当前每行可以炸到的人数， colHit[j] 记录当前每列可以炸到的人数， 碰到墙清0

public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int rowHit = 0, res = 0;
        int[] colHit = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j-1] == 'W') {
                    rowHit = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        rowHit += (grid[i][k] == 'E') ? 1 : 0;
                    }
                }
                if (i == 0 || grid[i-1][j] == 'W') {
                    colHit[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        colHit[j] += (grid[k][j] == 'E') ? 1 : 0;
                    }
                }
                if (grid[i][j] == '0') {
                    res = Math.max(res, rowHit + colHit[j]);
                }
            }
        }
        return res;
    }
}



// Straight forward solution 
// 分别计算上下左右各能炸到多少人
// 空间O(n^2) 时间O(mn)

public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] count = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'E') tmp++;
                if (grid[i][j] == 'W') tmp = 0;
                if (grid[i][j] == '0') {
                    count[i][j] += tmp;
                    res = Math.max(count[i][j], res);
                }
            }
            tmp = 0;
            for (int j = n-1; j >= 0; j--) {
                if (grid[i][j] == 'E') tmp++;
                if (grid[i][j] == 'W') tmp = 0;
                if (grid[i][j] == '0') {
                    count[i][j] += tmp;
                    res = Math.max(count[i][j], res);
                }
            }
        }
        for (int j = 0; j < n; j++) {
            int tmp = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 'E') tmp++;
                if (grid[i][j] == 'W') tmp = 0;
                if (grid[i][j] == '0') {
                    count[i][j] += tmp;
                    res = Math.max(count[i][j], res);
                }
            }
            tmp = 0;
            for (int i = m-1; i >= 0; i--) {
                if (grid[i][j] == 'E') tmp++;
                if (grid[i][j] == 'W') tmp = 0;
                if (grid[i][j] == '0') {
                    count[i][j] += tmp;
                    res = Math.max(count[i][j], res);
                }
            }
        }
        return res;
    }
}