// Sourse : https://leetcode.com/problems/search-in-rotated-sorted-array/
// Date   : 2016-10-05

/***********************************************************************
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 *
 **********************************************************************/

// solution 1:
// compare the middle element with the left element to decide which part is in order
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
                
            if (nums[mid] >= nums[left]) {
                if (target < nums[mid] && target >= nums[left]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
}


// solution 2:  两次binary search
// https://discuss.leetcode.com/topic/3538/concise-o-log-n-binary-search-solution


// solution 3:

public class Solution {
    public int search(int[] nums, int target) {
        /* if target is at the right of mid
        ------------------pivot---mid---target----    nums[0] > nums[mid], nums[0] > target, nums[mid] < target; 111 010
        --------mid-------pivot---target----------    nums[0] < nums[mid], nums[0] > target, nums[mid] > target; 010 111
        ---mid---target---pivot-------------------    nums[0] < nums[mid], nums[0] < target, nums[mid] < target; 001 100
        */
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = left + (right-left)/2;
            if ((nums[0] <= nums[mid]) ^ (nums[0] > target) ^ (nums[mid] >= target)) {
                left = mid + 1;       // (left, mid]
                System.out.println("left:" + left);
            } else {
                right = mid;         // (mid, right]
                System.out.println("right:" + right);
            }
        }
        return nums[left] == target ? left : -1;
    }
}