// Sourse : https://leetcode.com/problems/3sum-smaller/
// Date   : 2017-01-08

/***********************************************************************
 *
 * Given an array of n integers nums and a target, find the number of index 
 * triplets i, j, k with 0 <= i < j < k < n that satisfy the condition 
 * nums[i] + nums[j] + nums[k] < target.
 * 
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 * 
 * Return 2. Because there are two triplets which sums are less than 2:
 * 
 * [-2, 0, 1]
 * [-2, 0, 3]
 * Follow up:
 * Could you solve it in O(n2) runtime?
 *
 **********************************************************************/

public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length-2; i++) {
            int low = i+1, high = nums.length-1, sum = target-nums[i];
            while (low < high) {
                if (nums[low] + nums[high] < sum) {
                    res += (high-low); 
                    low++;
                } else {
                    high--;
                }
            }
        }
        return res;
    }
}