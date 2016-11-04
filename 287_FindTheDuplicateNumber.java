// Sourse : https://leetcode.com/problems/find-the-duplicate-number/
// Date   : 2016-11-03

/***********************************************************************
 *
 * Given an array nums containing n + 1 integers where each integer is between 
 * 1 and n (inclusive), prove that at least one duplicate number must exist. 
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 ***********************************************************************/

// O(NlogN) time, O(1) space
// 将1-n的值二分，mid = （low+high）/2, count数组中<=mid的个数，如果个数>mid，则high = mid-1， else low = mid + 1；

public class Solution {
    public int findDuplicate(int[] nums) {
        int high = nums.length-1, low = 1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            int countLess = 0;
            for (int num : nums) {
                if (num <= mid) {
                    countLess++;
                } 
            }
            if (countLess > mid) {
                high = mid - 1;
            } else {
                 low = mid + 1;
            }
        }
        return low;
    }
}

// O(N) time, O(1) space
// Floyd's cycle finding algorithm
// 与linkedlist里面找环类似

public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0, find = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break; 
        }
        while (true) {
            slow = nums[slow];
    		find = nums[find];
    		if (slow == find)
			    return slow;
        }
    }
}


