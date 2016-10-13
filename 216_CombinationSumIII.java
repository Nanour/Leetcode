// Sourse : https://leetcode.com/problems/combination-sum-iii/
// Date   : 2016-10-12

/***********************************************************************
 *
 * Find all possible combinations of k numbers that add up to a number n, 
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Example 1:
 * Input: k = 3, n = 7
 * Output:
 * [[1,2,4]]
 * Example 2:
 * Input: k = 3, n = 9
 * Output:
 * [[1,2,6], [1,3,5], [2,3,4]]
 *
 **********************************************************************/

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtracking(res, new ArrayList<Integer>(), k, n, 1);
        return res;
    }
    private void backtracking(List<List<Integer>> res, List<Integer> path, int k, int target, int start) {
        if (path.size() == k && target == 0) {
            res.add(new ArrayList<Integer>(path));
            return ;
        }
        if (path.size() < k && target > 0) {
            for (int i = start; i <= 9; i++) {
                path.add(i);
                backtracking(res, path, k, target-i, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}