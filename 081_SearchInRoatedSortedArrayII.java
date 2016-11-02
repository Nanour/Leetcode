// Sourse : https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
// Date   : 2016-11-01

/***********************************************************************
 *
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array
 *
 **********************************************************************/
// solution one
public class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            while (mid != left && nums[mid] == nums[left]) left++;
            while (mid != right && nums[mid] == nums[right]) right--;
            if (nums[mid] >= nums[left]) {
                if (target <= nums[mid] && target >= nums[left]) right = mid;
                else left = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid;
            }
        }
        return nums[left] == target;
    }
}

// just start++
public class Solution {
    public boolean search(int[] nums, int target) {
        // note here end is initialized to len instead of (len-1)
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > nums[start]) { // nums[start..mid] is sorted
                // check if target in left half
                if (target < nums[mid] && target >= nums[start]) end = mid;
                else start = mid + 1;
            } else if (nums[mid] < nums[start]) { // nums[mid..end] is sorted
                // check if target in right half
                if (target > nums[mid] && target < nums[start]) start = mid + 1;
                else end = mid;
            } else { // have no idea about the array, but we can exclude nums[start] because nums[start] == nums[mid]
                start++;
            }
        }
        return false;
    }
}