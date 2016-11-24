// Sourse : https://leetcode.com/problems/shortest-distance-from-all-buildings/
// Date   : 2016-11-23

/***********************************************************************
 *
 * You want to build a house on an empty land which reaches all buildings in 
 * the shortest amount of distance. You can only move up, down, left and right. 
 * You are given a 2D grid of values 0, 1 or 2, where:
 * 
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 * For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
 * 
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
 *
 ***********************************************************************/

// bfs O(m^2*n^2)
// https://discuss.leetcode.com/topic/31925/java-solution-with-explanation-and-time-complexity-analysis

public class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        Queue<int[]> queue = new LinkedList<int[]>();
        int[][] reach = new int[grid.length][grid[0].length];
        int buildingNumber = 0;
        int[] xdir = {1, -1, 0, 0};
        int[] ydir = {0, 0, 1, -1};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = -1;
                    buildingNumber++;
                }
                if (grid[i][j] == 2) {
                    grid[i][j] = -2;
                }
            }
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1) {
                    queue.offer(new int[]{i, j});
                    boolean[][] isVisited = new boolean[grid.length][grid[0].length];
                    int level = 1;
                    
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] curr = queue.poll();
                            for (int freq = 0; freq < 4; freq++) {
                                int xIndex = curr[0] + xdir[freq];
                                int yIndex = curr[1] + ydir[freq];
                                if (xIndex < 0 || xIndex >= grid.length || yIndex < 0 || yIndex >= grid[0].length 
                                            || grid[xIndex][yIndex] < 0 || isVisited[xIndex][yIndex]) continue;
                                            
                                grid[xIndex][yIndex] += level;
                                reach[xIndex][yIndex]++;
                                
                                isVisited[xIndex][yIndex] = true;
                                queue.offer(new int[]{xIndex, yIndex});
                            }
                        }
                        level++;
                    }
                }
            }
        }
       
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0 && reach[i][j] == buildingNumber) {
                   res = Math.min(res, grid[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}