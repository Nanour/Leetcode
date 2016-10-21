// Sourse : https://leetcode.com/problems/third-maximum-number/
// Date   : 2016-10-20

/***********************************************************************
 *
 * Given a non-empty array of integers, return the third maximum DISTINCT number in this array. 
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 **********************************************************************/

// this is so stupid :)

public class Solution {
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE, mid = max, min = max;
        for (int ele : nums) {
            if (ele > max) {
                min = mid;
                mid = max;
                max = ele;
            } else if (max > ele && ele > mid) {
                min = mid;
                mid = ele;
            } else if (mid > ele && ele > min) {
                min = ele;
            }
        }
        return (int)(min != Long.MIN_VALUE ? min : max);
    }
}