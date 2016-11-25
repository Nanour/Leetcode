// Sourse : https://leetcode.com/problems/number-of-boomerangs/
// Date   : 2016-11-24

/***********************************************************************
 *
 * Given n points in the plane that are all pairwise distinct, a "boomerang" 
 * is a tuple of points (i, j, k) such that the distance between i and j equals 
 * the distance between i and k (the order of the tuple matters).
 * 
 * Find the number of boomerangs. You may assume that n will be at most 500 and 
 * coordinates of points are all in the range [-10000, 10000] (inclusive).
 *
 **********************************************************************/

// don't actually count the distance
// find all elements has same distance to point[i]
// for each point[i], and each d, compute val*(val-1) 排列组合得到个数

public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int d = dist(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0)+1);
            }
            for (int val : map.values()) {
                res += (val * (val-1));
            }
            map.clear();
        }
        return res;
    }
    private int dist(int[] a, int[] b) {
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return x*x + y*y;
    }
}