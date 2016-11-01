// Sourse : https://leetcode.com/problems/house-robber/
// Date   : 2016-10-27

/***********************************************************************
 *
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint 
 * stopping you from robbing each of them is that adjacent houses have 
 * security system connected and it will automatically contact the police 
 * if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money 
 * of each house, determine the maximum amount of money you can rob tonight 
 * without alerting the police.
 *
 **********************************************************************/

public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] res = new int[2];
        res[0] = nums[0];
        res[1] = Math.max(res[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            res[i%2] = Math.max(res[(i-2)%2]+nums[i], res[(i-1)%2]);
        }
        return res[(nums.length-1)%2];
    }
}