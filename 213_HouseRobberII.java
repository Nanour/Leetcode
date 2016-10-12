// Sourse : https://leetcode.com/problems/house-robber-ii/
// Date   : 2016-10-11

/***********************************************************************
 *
 * After robbing those houses on that street, the thief has found himself 
 * a new place for his thievery so that he will not get too much attention. 
 * This time, all houses at this place are arranged in a circle. That means 
 * the first house is the neighbor of the last one. Meanwhile, the security 
 * system for these houses remain the same as for those in the previous street.
 * Given a list of non-negative integers representing the amount of money of 
 * each house, determine the maximum amount of money you can rob tonight without 
 * alerting the police.
 * 
 **********************************************************************/

// split to two 
// 9,2,3,4,5,2,5,7 分成 9,2,3,4,5,2,5 和 2,3,4,5,2,5,7
// 如果只有两个数，取最大值

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robMost(nums, 1, nums.length-1), robMost(nums, 0, nums.length-2));
    }
    private int robMost(int[] nums, int start, int end) {
        int[] res = new int[2];
        res[0] = nums[start];
        res[1] = Math.max(res[0], nums[start+1]);
        for (int i = start+2, j = 2; i <= end; i++, j++) {
            res[j%2] = Math.max(res[(j-1)%2], res[(j-2)%2]+nums[i]);
        }
        return res[(nums.length-2)%2];
    }
}