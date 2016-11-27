// Sourse : https://leetcode.com/problems/patching-array/
// Date   : 2016-11-26

/***********************************************************************
 *
 * Given a sorted positive integer array nums and an integer n, add/patch 
 * elements to the array such that any number in range [1, n] inclusive can 
 * be formed by the sum of some elements in the array. Return the minimum 
 * number of patches required.
 *
 **********************************************************************/

// need to check miss > 0, otherwise if n = 2^31-1, it is an infinite loop
// [1,5,10] n = 20
// 加上2之后可以组成到3，下一个数是5，所以加上4，加上4后可以组成到(1+2+4)+5=12, 下一个数是10，现在可以组成到22 > 20 结束

public class Solution {
    public int minPatches(int[] nums, int n) {
        int miss = 1, added = 0, i = 0;
        while (miss <= n && miss > 0) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss <<= 1;
                added++;
            }
        }
        return added;
    }
}