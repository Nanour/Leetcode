// Sourse : https://leetcode.com/problems/combination-sum/
// Date   : 2016-10-12

/***********************************************************************
 *
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations 
 * in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7, 
 * A solution set is: 
 * [
 *  [7],
 *  [2, 2, 3]
 * ]
 *
 **********************************************************************/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
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
            path.add(candidates[i]);
            backtracking(res, candidates, target-candidates[i], path, i);   // not i+1 because each element can be used for several times
            path.remove(path.size()-1);
        }
    }
}