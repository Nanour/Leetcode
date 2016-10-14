// Sourse : https://leetcode.com/problems/permutation-sequence/
// Date   : 2016-10-13

/***********************************************************************
 *
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 *  "123"
 *  "132"
 *  "213"
 *  "231"
 *  "312"
 *  "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 *
 **********************************************************************/

// 假设 求 [1,2,3,4] 中第12个permutation
// 一共有4！= 24 个permutations 1xxx，2xxx，3xxx，4xxx
// 所以第12个(start from 0 所以是-1) 在 idx = （12-1)/(24/4) = 2， 即3xxx中 
// 3xxx中有3！= 6个permutations, 31xx，32xx，34xx 现在在第几个呢 
// 11%6=5，idx = 5/(6/3) = 2，即在34xx中

public class Solution {
    String res = "";
    public String getPermutation(int n, int k) {
        int permutation = 1;
        for (int i = 1; i <= n; i++) {
            permutation *= i;
        }
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        backtracking(nums, permutation, k-1);
        return res;
    }
    private void backtracking(List<Integer> nums, int permutation, int k) {
        if (nums.size() == 0) return ;
        permutation /= nums.size();
        int idx = k/permutation;
        res += String.valueOf(nums.get(idx));
        nums.remove(nums.get(idx));
        backtracking(nums, permutation, k%permutation);
    }
}







// 暴力枚举 超时
public class Solution {
    String res = "";
    int step = 0;
    public String getPermutation(int n, int k) {
        step = k;
        backtracking("", n);
        return res; 
    }
    private void backtracking(String path, int n) {
        if (path.length() == n) {
            step--;
            if (step == 0) {
                res = path;
                return ;
            }
        }
        if (path.length() < n && step > 0) {
            for (int i = 1; i <= n; i++) {
                if (path.contains(String.valueOf(i))) continue;
                path += String.valueOf(i);
                backtracking(path, n);
                path = path.substring(0,path.length()-1);
            }
        }
    }
}
