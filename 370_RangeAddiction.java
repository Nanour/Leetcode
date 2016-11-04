// Sourse : https://leetcode.com/problems/range-addition/
// Date   : 2016-11-03

/***********************************************************************
 *
 * Assume you have an array of length n initialized with all 0's and are given k update operations.
 * 
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each 
 * element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 * 
 * Return the modified array after all k operations were executed.
 *
 ***********************************************************************/

// O(n+k) 
// 如果全部都刷新一遍会超时╮(╯_╰)╭

public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            res[update[0]] += update[2];
            if (update[1] < length-1) res[update[1] + 1] -= update[2];
        }
        for (int i = 1; i < res.length; i++) {
            res[i] += res[i-1];
        }
        return res;
    }
}