// Sourse : https://leetcode.com/problems/longest-increasing-subsequence/
// Date   : 2016-11-01

/***********************************************************************
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *  
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
 * Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 *
 * Your algorithm should run in O(n2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 **********************************************************************/

// O(n)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (curr < nums[j]) {
                    dp[j] = Math.max(dp[j], dp[i]+1);
                    max = Math.max(max, dp[j]);
                }
            }
        }
        return max;
    }
}


// O(nlogn)
// [1, 6, 8, 9 ,2, 3]
// The sequence will be like:
// 1;
// 1, 6;
// 1, 6, 8;
// 1, 6, 8, 9;
// 1, 2, 8, 9;
// 1, 2, 3, 9;
public class Solution {
    public int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;
        for(int x : nums) {
            int pos = Arrays.binarySearch(dp, 0, len, x); // return element index, otherwise return -(insertPos)-1;
            if(pos < 0) {
                pos = -(pos + 1);
            }
            dp[pos] = x;
            if(pos == len) {
                len++;
            }
        }
        return len;
    }
}