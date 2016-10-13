// Sourse : https://leetcode.com/problems/permutations/
// Date   : 2016-10-12

/***********************************************************************
 *
 * Given a collection of distinct numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 **********************************************************************/

// insert value  6ms
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        helper(nums, 0, list, res);
        return res;
    }
    public void helper(int[] nums, int n, List<Integer> list, List<List<Integer>> res) {
        if (n == nums.length) {
            res.add(list);
            return ;
        }
        int size = list.size();
        for (int i = 0; i <= size; i++) {
            List<Integer> temp = new ArrayList<Integer>(list);
            temp.add(i, nums[n]);
            helper(nums, n+1, temp, res);
        }
    }
}

// more general  10ms
// https://discuss.leetcode.com/topic/46159/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtracking(res, nums, new ArrayList<Integer>());
        return res;
    }
    private void backtracking(List<List<Integer>> res, int[] nums, List<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<Integer>(path));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) continue; 
            path.add(nums[i]);
            backtracking(res, nums, path);
            path.remove(path.size()-1);
        }
    }
}