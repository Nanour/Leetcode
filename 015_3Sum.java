// Sourse : https://leetcode.com/problems/3sum/
// Date   : 2016-11-28

/***********************************************************************
 *
 * Given an array S of n integers, are there elements a, b, c in S such 
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 *  [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 **********************************************************************/

// 26ms beats 94%

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] > 0) return res;                                    // 因为已经排序，所以当最小的数大于0，可以退出
            int low = i+1, high = nums.length-1, target = 0-nums[i];
            while (low < high) {
                if (nums[low] + nums[high] == target) {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));        // Arrays.asList()的用法
                    while (low < high && nums[high] == nums[high-1]) high--;       // 循环避免重复， 注意先加上判断条件 low < high
                    while (low < high && nums[low] == nums[low+1]) low++; 
                    high--;                                                       // 找到一组后继续找，不是break;
                    low++;
                } else if (nums[low] + nums[high] > target) {
                    high--;
                } else {
                    low++;
                }
            }    
            while (i < nums.length-2 && nums[i] == nums[i+1]) i++;         // 循环避免重复, 注意先加上判断条件
        }
        return res;
    }
}