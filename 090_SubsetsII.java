// Sourse : https://leetcode.com/problems/subsets-ii/
// Date   : 2016-10-12

/***********************************************************************
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,2], a solution is:
 * [
 *  [2],
 *  [1],
 *  [1,2,2],
 *  [2,2],
 *  [1,2],
 *  []
 * ]
 *
 **********************************************************************/

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtracking(res, nums, new ArrayList<Integer>(), 0);
        return res;
    }
    private void backtracking(List<List<Integer>> res, int[] nums, List<Integer> path, int start) {
        res.add(new ArrayList<Integer>(path));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue; 
            path.add(nums[i]);
            backtracking(res, nums, path, i+1);
            path.remove(path.size()-1);
        }
    }
}