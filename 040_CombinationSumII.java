// Sourse : https://leetcode.com/problems/combination-sum-ii/
// Date   : 2016-10-12

/***********************************************************************
 *
 * Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
 * A solution set is: 
 * [
 *  [1, 7],
 *  [1, 2, 5],
 *  [2, 6],
 *  [1, 1, 6]
 * ]
 *
 **********************************************************************/

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtracking(res, candidates, target, new ArrayList<Integer>(), 0);
        return res;
    }
    private void backtracking(List<List<Integer>> res, int[] candidates, int target, List<Integer> path, int start) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(path));
            return ;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < 0) return ;
            if (i > start && candidates[i] == candidates[i-1]) continue;
            path.add(candidates[i]);
            backtracking(res, candidates, target-candidates[i], path, i+1);
            path.remove(path.size()-1);
        }
    }
}