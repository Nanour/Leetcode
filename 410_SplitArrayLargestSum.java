// Sourse : https://leetcode.com/problems/split-array-largest-sum/
// Date   : 2016-11-03

/***********************************************************************
 *
 * Given an array which consists of non-negative integers and an integer m, 
 * you can split the array into m non-empty continuous subarrays. Write an 
 * algorithm to minimize the largest sum among these m subarrays.
 * 
 * Note:
 * Given m satisfies the following constraint: 1 ≤ m ≤ length(nums) ≤ 14,000.
 ***********************************************************************/

// 吊炸天之死我也想不出的二分还可以这样用系列ORZ。。。

// nums = [1, 2, 3, 4, 5], m = 3
// left = max = 5， right = sum = 15;
// mid = 10, 此时找到和最大小于等于10的子数组个数， 此时为2，[1,2,3,4],[5], 不能分成3份，说明mid值太大，right = mid - 1；
// mid = 7, 此时为3， [1,2,3],[4],[5]，此时已经找到三组，再次尝试降低right = mid - 1；
// mid = 5， 此时为4， [1,2],[3],[4],[5]，此时已经找到四组， left = mid + 1;
// 此时left = 6， right = 6， mid = 6， right = mid - 1 = 5;
// 此时left = 6， right = 5， break；
// 返回 left

public class Solution {
    public int splitArray(int[] nums, int m) {
        int sum = 0, max = 0;
        for (int i : nums) {
            max = Math.max(max, i);
            sum += i;
        }
        int left = max, right = sum;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (valid(nums, m, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean valid(int[] nums, int m, int mid) {
        int currSum = 0, count = 1;
        for (int i : nums) {
            currSum += i;
            if (currSum > mid) {
                currSum = i;
                count++;
                if (count > m) {
                    return false;
                }
            }
        } 
        return true;
    }
}