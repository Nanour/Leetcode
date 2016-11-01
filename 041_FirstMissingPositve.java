// Sourse : https://leetcode.com/problems/first-missing-positive/
// Date   : 2016-10-31

/***********************************************************************
 *
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 *
 **********************************************************************/

// put i at nums[i-1]

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; ++ i) {
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i])
                swap(nums, i, nums[i] - 1);
        }
        for(int i = 0; i < n; ++ i) {
            if(nums[i] != i + 1)
                return i + 1;
        }        
        return n + 1;
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}