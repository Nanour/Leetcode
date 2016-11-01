// Sourse : https://leetcode.com/problems/search-insert-position/
// Date   : 2016-10-31

/***********************************************************************
 *
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 **********************************************************************/

// reason why should return low:
// When low and high cross each other, break out of the loop. Now the question is, which one to return low or high. 
// if we consider carefully, low represents the lower bound of the potential 
// positions where we can insert the elements. Meaning the position must be at least 
// low or greater. Since low and high have already crossed each other, 
// We cannot insert at high. We have to insert at low. Hence we return low

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int low = 0, high = nums.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}