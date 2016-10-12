// Sourse : https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
// Date   : 2016-10-10

/***********************************************************************
 *
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * Your function should return length = 5, with the first five elements of nums 
 * being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 * 
 **********************************************************************/

// version 1
public int removeDuplicates(int[] nums) {
   int i = 0;
   for (int n : nums)
      if (i < 2 || n > nums[i - 2])
         nums[i++] = n;
   return i;
}

// version 2

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length <= 2) {
            return nums.length;
        }
        int start = 2, first = nums[0], second = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int curr = nums[i];
            if ((curr == first) && (curr == second)) {
                continue;
            } else {
                nums[start++] = curr;
                first = second;
                second = curr;
            }
        }
        return start;
    }
}