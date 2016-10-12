// Sourse : https://leetcode.com/problems/sort-transformed-array/
// Date   : 2016-10-10

/***********************************************************************
 *
 * Given a sorted array of integers nums and integer values a, b and c. 
 * Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.
 * The returned array must be in sorted order.
 * Expected time complexity: O(n)
 * Example:
 * nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,
 * Result: [3, 9, 15, 33] 
 * nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5
 * Result: [-23, -5, 1, 7]
 * 
 **********************************************************************/

public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int i = 0, j = nums.length-1;
        int index = a > 0 ? j : i;
        int[] res = new int[nums.length];
        while (i <= j) {
            if (a > 0) {
                res[index--] = quad(nums[i], a, b, c) > quad(nums[j], a, b, c) ? quad(nums[i++], a, b, c) : quad(nums[j--], a, b, c);
            } else {
                res[index++] = quad(nums[i], a, b, c) < quad(nums[j], a, b, c) ? quad(nums[i++], a, b, c) : quad(nums[j--], a, b, c);
            }
        }
        return res;
    }
    
    private int quad(int x, int a, int b, int c) {
        return a*x*x + b*x + c;
    }
}