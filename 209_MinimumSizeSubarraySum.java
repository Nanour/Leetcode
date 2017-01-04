// Sourse : https://leetcode.com/problems/minimum-size-subarray-sum/
// Date   : 2016-10-10

/***********************************************************************
 *
 * Given an array of n positive integers and a positive integer s, find 
 * the minimal length of a subarray of which the sum ≥ s. If there isn't one, 
 * return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 * 
 **********************************************************************/

// O(n)
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int sum = 0, i = 0, len = Integer.MAX_VALUE, start = 0;
        while (i < nums.length) {
            sum += nums[i++];
            while (sum >= s) {
                len = Math.min(len, i-start);
                sum -= nums[start++];
            }
        } 
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}

// O(nlogn)

// https://discuss.leetcode.com/topic/26814/o-n-o-nlogn-solutions-both-o-1-space