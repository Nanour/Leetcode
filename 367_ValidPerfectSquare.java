// Sourse : https://leetcode.com/problems/valid-perfect-square/
// Date   : 2016-11-01

/***********************************************************************
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 **********************************************************************/

public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1)
            return true;
        long low = 1, high = num / 2;
        long nums = (long)num;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if ((mid * mid) == nums) {
                return true;
            } else if ((mid * mid) < nums) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}