// Sourse : https://leetcode.com/problems/trapping-rain-water-ii/
// Date   : 2016-10-06

/***********************************************************************
 *
 * Given an m x n matrix of positive integers representing the height of each 
 * unit cell in a 2D elevation map, compute the volume of water it is able to 
 * trap after raining.
 **********************************************************************/


// 四周向中间

public class Solution {
    class Cell{
        int x, y, h;
        Cell(int xx, int yy, int hh){
            this.x = xx;
            this.y = yy;
            this.h = hh;
        }
    }
    class CellComparator implements Comparator<Cell> {
        public int compare(Cell c1, Cell c2) {
            return c1.h - c2.h;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0) 
            return 0;
        Queue<Cell> minHeap = new PriorityQueue<Cell>(1, new CellComparator());
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[][] visit = new int[m][n];
        
        // left & right edge
        for (int i = 0; i < m; i++) {
            minHeap.offer(new Cell(i, 0, heightMap[i][0]));
            minHeap.offer(new Cell(i, n-1, heightMap[i][n-1]));
            visit[i][0] = 1;
            visit[i][n-1] = 1;
        }
        
        // top & bottom edge
        for (int j = 1; j < n-1; j++) {
            minHeap.offer(new Cell(0, j, heightMap[0][j]));
            minHeap.offer(new Cell(m-1, j, heightMap[m-1][j]));
            visit[0][j] = 1;
            visit[m-1][j] = 1;
        }
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        int res = 0;
        while (!minHeap.isEmpty()) {
            Cell curr = minHeap.poll();
            for (int i = 0; i < 4; i++) {
                int x = curr.x + dx[i];
                int y = curr.y + dy[i];
                if (x >= 0 && x < m && y >= 0 && y < n && visit[x][y] == 0) {
                    visit[x][y] = 1;
                    minHeap.offer(new Cell(x, y, Math.max(heightMap[x][y], curr.h)));         // 已经加过水的高度填平，取高值
                    res += Math.max(0, curr.h - heightMap[x][y]);                             // 低的填水
                }   
            }
        }
        return res;
    }
}