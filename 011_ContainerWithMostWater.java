// Sourse : https://leetcode.com/problems/container-with-most-water/
// Date   : 2016-10-04

/***********************************************************************
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two 
 * lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 **********************************************************************/

// Two pointer
// Max area depends on the lowest line

public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int res = 0;
        while (left < right) {
            int water = (right-left) * Math.min(height[right], height[left]);
            res = Math.max(res, water);
            if (height[right] < height[left]) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}