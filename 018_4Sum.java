// Sourse : https://leetcode.com/problems/4sum/
// Date   : 2016-11-28

/***********************************************************************
 *
 * Given an array S of n integers, are there elements a, b, c, and d in S 
 * such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Note: The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * [
 *  [-1,  0, 0, 1],
 *  [-2, -1, 1, 2],
 *  [-2,  0, 0, 2]
 * ]
 **********************************************************************/

// 75ms beats 58.72%

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;
        Arrays.sort(nums);              
        for (int i = 0; i < nums.length-3; i++) {                 // 这里不可以当某个数大于target时，结束，因为target可能为付
            for (int j = i+1; j < nums.length-2; j++) {
                int low = j+1, high = nums.length-1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high])); 
                        while (low < high && nums[low] == nums[low+1]) low++;
                        while (low < high && nums[high] == nums[high-1]) high--;
                        low++; high--;
                    } else if (sum < target) {
                        low++;
                    } else {
                        high--;
                    }
                }
                while (j < nums.length-2 && nums[j] == nums[j+1]) j++;
            }
            while (i < nums.length-3 && nums[i] == nums[i+1]) i++; 
        }
        return res;
    }
}