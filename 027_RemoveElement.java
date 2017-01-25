// Sourse : https://leetcode.com/problems/remove-element/
// Date   : 2017-01-08

/***********************************************************************
 *
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 **********************************************************************/

public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != val)
                nums[i++] = nums[j];
        }
        return i;
    }
}