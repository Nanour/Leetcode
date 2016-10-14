// Sourse : https://leetcode.com/problems/permutation-sequence/
// Date   : 2016-10-13

/***********************************************************************
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *  1,2,3 → 1,3,2
 *  3,2,1 → 1,2,3
 *  1,1,5 → 1,5,1
 *
 **********************************************************************/

// [6，3，4，9，8，7，1]
// 从尾部开始找到 i 使得 nums[i] > nums[i-1]
//  如果i不为0 再从尾部开始找 j 使得 nums[j] > nums[i-1]
//  交换i-1 和 j
// reverse [i, end]

public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-1, j = i;
        while (i > 0 && nums[i] <= nums[i-1]) i--;
        if (i > 0) {
            while (j > i && nums[j] <= nums[i-1]) j--;
            swap(nums, i-1, j);
        }
        reverse(nums, i, nums.length-1);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}