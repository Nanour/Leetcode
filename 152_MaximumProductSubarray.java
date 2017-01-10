// Sourse : https://leetcode.com/problems/maximum-product-subarray/
// Date   : 2017-01-08

/***********************************************************************
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * 
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 *
 **********************************************************************/

public class Solution {
    public int maxProduct(int[] nums) {
         int res = nums[0], min = 1, max = 1;
         
         for (int i : nums) {
             if (i  < 0) {
                 int temp = min;
                 min = max;
                 max = temp;
             }
             min = Math.min(i, min * i);
             max = Math.max(i, max * i);
             
             res = Math.max(res, max);
             System.out.println(min + " " + max + " " + res);
         }
         return res;
    }
}