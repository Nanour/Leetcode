// Sourse : https://leetcode.com/problems/walls-and-gates/
// Date   : 2016-11-23

/***********************************************************************
 *
 * You are given a m x n 2D grid initialized with these three possible values.
 * 
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 * 
 * For example, given the 2D grid:
 *  INF  -1  0  INF
 *  INF INF INF  -1
 *  INF  -1 INF  -1
 *  0  -1 INF INF
 * After running your function, the 2D grid should be:
 *  3  -1   0   1
 *  2   2   1  -1
 *  1  -1   2  -1
 *  0  -1   3   4
 *
 ***********************************************************************/

// dfs O(MN)
public class Solution {
    public void wallsAndGates(int[][] rooms) {
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    fillDistance(i, j, rooms, 1);
                }
            }
        }
    }
    
    private void fillDistance(int row, int col, int[][] rooms, int dist) {
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        for (int i = 0; i < 4; i++) {
            int xIndex = row + x[i], yIndex = col + y[i];
            if (xIndex < 0 || xIndex >= rooms.length || yIndex < 0 || yIndex >= rooms[0].length 
                        || rooms[xIndex][yIndex] <= dist) continue;
            rooms[xIndex][yIndex] = dist;
            fillDistance(xIndex, yIndex, rooms, dist+1);
        }
    }
}

// bfs O(MN)
public class Solution {
     public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) 
                    queue.offer(new int[]{i,j});
            }
        }
        int[] xdir = {1, -1, 0, 0};
        int[] ydir = {0, 0, 1, -1};
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int i = 0; i < 4; i++) {
                int xIndex = curr[0] + xdir[i];
                int yIndex = curr[1] + ydir[i];
                if (xIndex < 0 || xIndex >= rooms.length || yIndex < 0 || yIndex >= rooms[0].length 
                        || rooms[xIndex][yIndex] <= rooms[curr[0]][curr[1]]) continue;
                rooms[xIndex][yIndex] = rooms[curr[0]][curr[1]] + 1;
                queue.offer(new int[]{xIndex, yIndex});
            }
        }
    }
}