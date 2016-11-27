// Sourse : https://leetcode.com/problems/burst-balloons/
// Date   : 2016-11-26

/***********************************************************************
 *
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a 
 * number on it represented by array nums. You are asked to burst all the 
 * balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
 * Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * 
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * 
 * Note: 
 * (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 *
 **********************************************************************/


// 新建一个数组
// 10ms, beats 90%

public class Solution {
	public int maxCoins(int[] iNums) {
	    int[] nums = new int[iNums.length + 2];
	    int n = 1;
	    for (int x : iNums) if (x > 0) nums[n++] = x;
	    nums[0] = nums[n++] = 1;


	    int[][] memo = new int[n][n];
	    return burst(memo, nums, 0, n - 1);
	}

	public int burst(int[][] memo, int[] nums, int left, int right) {
	    if (left + 1 == right) return 0;
	    if (memo[left][right] > 0) return memo[left][right];
	    int ans = 0;
	    for (int i = left + 1; i < right; ++i)    // (left, right)
	        ans = Math.max(ans, nums[left] * nums[i] * nums[right] 
	        + burst(memo, nums, left, i) + burst(memo, nums, i, right));
	    memo[left][right] = ans;
	    return ans;
	}
}

// 使用原来数组，假设num[-1] 和 num[length] 都为1
// 54ms, beats 2%

// So the range can be divided into
// start - 1, maxCoin(start, i - 1), i, maxCoins(i + 1, end), end + 1

public class Solution {
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        return maxCoins(nums, 0, nums.length - 1, dp);
    }
    private int maxCoins(int[] nums, int start, int end, int[][] dp) {
        if (start > end) {
            return 0; 
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        int max = nums[start];
        for (int i = start; i <= end; i++) {
            int val = maxCoins(nums, start, i-1, dp) +          // [start, end]
                      get(nums, i) * get(nums, start-1) * get(nums, end+1) +
                      maxCoins(nums, i+1, end, dp);
            max = Math.max(max, val);
        }
        dp[start][end] = max;
        return max;
    }
    private int get(int[] nums, int i) {
        if (i == -1 || i == nums.length) {
            return 1;
        } 
        return nums[i];
    }
}