// Sourse : https://leetcode.com/problems/3sum-closest/
// Date   : 2017-01-08

/***********************************************************************
 *
 * Given an array S of n integers, find three integers in S such that 
 * the sum is closest to a given number, target. Return the sum of the 
 * three integers. You may assume that each input would have exactly one solution.
 * 
 *   For example, given array S = {-1 2 1 -4}, and target = 1.
 *
 *   The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 **********************************************************************/


public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            int low = i+1, high = nums.length-1;
            while (low < high) {
                int sum = nums[low] + nums[high] + nums[i];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                } 
                if (nums[i] + nums[low] + nums[high] < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return res;
    }
}