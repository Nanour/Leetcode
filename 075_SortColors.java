// Sourse : https://leetcode.com/problems/sort-colors/
// Date   : 2016-10-10

/***********************************************************************
 *
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 * For example, Given s = “eceba”,
 * T is "ece" which its length is 3.
 * 
 **********************************************************************/

// quick select partition

public class Solution {
    public void sortColors(int[] nums) {
        int start = 0, i = 0, end = nums.length-1;
        while(i <= end) {
            switch(nums[i]) {
                case 0: swap(nums, start++, i++);
                        break;
                case 1: i++;
                        break;
                case 2: swap(nums, end--, i);
                        break;
            }
        }
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}