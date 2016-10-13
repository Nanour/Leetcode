// Sourse : https://leetcode.com/problems/subsets/
// Date   : 2016-10-12

/***********************************************************************
 *
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,3], a solution is:
 * [
 *  [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 *
 **********************************************************************/

// backtracking in general
// https://discuss.leetcode.com/topic/46159/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtracking(res, nums, new ArrayList<Integer>(), 0);
        return res;
    }
    private void backtracking(List<List<Integer>> res, int[] nums, List<Integer> path, int start) {
        res.add(new ArrayList<Integer>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(res, nums, path, i+1);
            path.remove(path.size()-1);
        }
    }
}