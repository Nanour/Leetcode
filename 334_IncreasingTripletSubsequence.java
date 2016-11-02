// Sourse : https://leetcode.com/problems/increasing-triplet-subsequence/
// Date   : 2016-11-01

/***********************************************************************
 *
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * 
 * Formally the function should:
 * Return true if there exists i, j, k 
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 *
 **********************************************************************/

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for(int x : nums) {
            int pos = Arrays.binarySearch(dp, 0, len, x);  // array need to be sorted to call this
            if(pos < 0) {
                pos = -(pos + 1);
            }
            dp[pos] = x;
            if(pos == len) {
                len++;
            }
            if (len == 3) {
                return true;
            }
        }
        return false;
    }
}