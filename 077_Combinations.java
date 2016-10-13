// Sourse : https://leetcode.com/problems/combinations/
// Date   : 2016-10-12

/***********************************************************************
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 * ]
 *
 **********************************************************************/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtracking(res, new ArrayList<Integer>(), k, n, 1);
        return res;
    }
    private void backtracking(List<List<Integer>> res, List<Integer> path, int k, int n, int start) {
        if (path.size() == k) {
            res.add(new ArrayList<Integer>(path));
            return ;
        }
        if (path.size() < k) {
            for (int i = start; i <= n; i++) {
                path.add(i);
                backtracking(res, path, k, n, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}