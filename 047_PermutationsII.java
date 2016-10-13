// Sourse : https://leetcode.com/problems/permutations-ii/
// Date   : 2016-10-12

/***********************************************************************
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 *  [1,1,2],
 *  [1,2,1],
 *  [2,1,1]
 * ]
 *
 **********************************************************************/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtracking(res, nums, new ArrayList<Integer>(), new boolean[nums.length]);
        return res;
    }
    private void backtracking(List<List<Integer>> res, int[] nums, List<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<Integer>(path));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i-1] && used[i-1])) continue;
            used[i] = true;
            path.add(nums[i]);
            backtracking(res, nums, path, used);
            used[i] = false;
            path.remove(path.size()-1);
        }
    }
}