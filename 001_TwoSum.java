// Sourse : https://leetcode.com/problems/two-sum/
// Date   : 2016-11-28

/***********************************************************************
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 **********************************************************************/

// hash 加查找/ two pointer 加排序

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);      // 先判断再put，避免当前数字重复相加两次得到target，例如 3+3 = 6
        }
        return result;
    }
}