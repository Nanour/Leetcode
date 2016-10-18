// Sourse : https://leetcode.com/problems/factor-combinations/
// Date   : 2016-10-15

/***********************************************************************
 *
 * Numbers can be regarded as product of its factors. For example,
 * 8 = 2 x 2 x 2;
 *  = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 *
 **********************************************************************/

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtracking(res, new ArrayList<Integer>(), n, 2);
        return res;
    }
    private void backtracking(List<List<Integer>> res, List<Integer> temp, int n, int start) {
        if (n == 1 && temp.size() > 1) {                      // 本身不需要
            res.add(new ArrayList<Integer>(temp));            // 复制一个new list
            return ;
        }
        if (n > 1) {
            for (int i = start; i <= n; i++) {                // i <= n  如果小于n的话递归事遍历不到n/i的值
                if (n % i == 0) {
                    temp.add(i);
                    backtracking(res, temp, n/i, i);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
}