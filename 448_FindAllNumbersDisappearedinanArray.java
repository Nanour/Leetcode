// Sourse : https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
// Date   : 2016-11-24

/***********************************************************************
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), 
 * some elements appear twice and others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume 
 * the returned list does not count as extra space.
 *
 **********************************************************************/

// 用nums的下标表示出现的number。如果出现了，将位于此下标的数字设为负，第二次循环如果数字为负则将此下标加入到list。


public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for (int num : nums) {
            int val = Math.abs(num)-1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i+1);
            }
        }
        return res;
    }
}