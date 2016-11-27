// Sourse : https://leetcode.com/problems/combination-sum-iv/
// Date   : 2016-11-26

/***********************************************************************
 *
 * Given an integer array with all positive numbers and no duplicates, find 
 * the number of possible combinations that add up to a positive integer target.
 * 
 * Example:
 * 
 * nums = [1, 2, 3]
 * target = 4
 *
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 
 * Note that different sequences are counted as different combinations.
 * 
 * Therefore the output is 7.
 *
 **********************************************************************/

// dfs   TLE use dp to avoid multi computes

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        return dfs(nums, target);
    }
    private int dfs(int[] nums, int target) {
        if (target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += dfs(nums, target-nums[i]);
        }
        return count;
    }
}



// with DP top-down solution

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return dfs(nums, target, dp);
    }
    private int dfs(int[] nums, int target, int[] dp) {
        if (target < 0) {
            return 0;
        }
        if (dp[target] != -1) {
            return dp[target];
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += dfs(nums, target-nums[i], dp);
        }
        dp[target] = count;
        return count;
    }
}


// bottom-up solution

public int combinationSum4(int[] nums, int target) {
    int[] comb = new int[target + 1];
    comb[0] = 1;
    for (int i = 1; i < comb.length; i++) {
        for (int j = 0; j < nums.length; j++) {
            if (i - nums[j] >= 0) {
                comb[i] += comb[i - nums[j]];
            }
        }
    }
    return comb[target];
}


