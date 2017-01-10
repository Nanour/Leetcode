// Sourse : https://leetcode.com/problems/maximum-subarray/
// Date   : 2017-01-08

/***********************************************************************
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * 
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 **********************************************************************/


//solution1: 
public class Solution {
    public int maxSubArray(int[] nums) {
        int pre = nums[0], res = 0, max = pre;
        for (int i = 1; i < nums.length; i++) {
            res = nums[i] + (pre > 0 ? pre : 0);
            max = Math.max(max, res);
            pre = res;
        }
        return max;
    }
}
//solution2:
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int min = 0, res = Integer.MIN_VALUE, prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            res = Math.max(res, prefixSum-min);
            min = Math.min(min, prefixSum);
        }
        return res;
    }
}