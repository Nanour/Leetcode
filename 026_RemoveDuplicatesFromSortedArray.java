// Sourse : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// Date   : 2016-10-10

/***********************************************************************
 *
 * Given a sorted array, remove the duplicates in place such that each element 
 * appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 
 * respectively. It doesn't matter what you leave beyond the new length.
 * 
 **********************************************************************/

// version 1

public int removeDuplicates(int[] nums) {
    int i = 0;
    for(int n : nums)
        if(i < 1 || n > nums[i - 1]) 
            nums[i++] = n;
    return i;
}

// version 2

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int start = 1, seen = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (curr != seen) {
                nums[start++] = curr;
                seen = curr;
            }
        }
        return start;
    }
}