// Sourse : https://leetcode.com/problems/dungeon-game/
// Date   : 2016-11-02

/***********************************************************************
 *
 * The demons had captured the princess (P) and imprisoned her in the bottom-right 
 * corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. 
 * Our valiant knight (K) was initially positioned in the top-left room and must 
 * fight his way through the dungeon to rescue the princess.
 * 
 * The knight has an initial health point represented by a positive integer. If at 
 * any point his health point drops to 0 or below, he dies immediately.
 * 
 * Some of the rooms are guarded by demons, so the knight loses health (negative 
 * integers) upon entering these rooms; other rooms are either empty (0's) or contain 
 * magic orbs that increase the knight's health (positive integers).
 * 
 * In order to reach the princess as quickly as possible, the knight decides to move 
 * only rightward or downward in each step.
 ***********************************************************************/

// fill from the P to K
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0) return 1;
        int m = dungeon.length, n = dungeon[0].length;
        int[][] health = new int[m][n];
        health[m-1][n-1] = Math.max(1, 1 - dungeon[m-1][n-1]);
        for (int i = m - 2; i >= 0; i--) {     // fill the last col
            health[i][n-1] = Math.max(1, health[i+1][n-1] - dungeon[i][n-1]); 
        }
        for (int j = n - 2; j >= 0; j--) {     // fill the last row
            health[m-1][j] = Math.max(1, health[m-1][j+1] - dungeon[m-1][j]);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                health[i][j] = Math.max(1, Math.min(health[i+1][j], health[i][j+1]) - dungeon[i][j]);
            }
        }
        return health[0][0];
    }
}