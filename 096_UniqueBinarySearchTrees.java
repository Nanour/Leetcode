// Sourse : https://leetcode.com/problems/unique-binary-search-trees/
// Date   : 2017-01-13

/***********************************************************************
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * 
 *   1         3     3      2      1
 *    \       /     /      / \      \
 *     3     2     1      1   3      2
 *    /     /       \                 \
 *   2     1         2                 3
 *
 **********************************************************************/

public class Solution {
    public int numTrees(int n) {
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i; j > 0; j--) {
                res[i] += res[i-j]*res[j-1];
            }
        }
        return res[n];
    }
}