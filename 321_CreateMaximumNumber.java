// Sourse : https://leetcode.com/problems/create-maximum-number/
// Date   : 2016-11-26

/***********************************************************************
 *
 * Given two arrays of length m and n with digits 0-9 representing two numbers. 
 * Create the maximum number of length k <= m + n from digits of the two. The 
 * relative order of the digits from the same array must be preserved. Return 
 * an array of the k digits. You should try to optimize your time and space complexity.
 *
 **********************************************************************/

// 先找到两个数组分别取i，k-i个元素能组成的最大值，遍历找到这些中的最大的

public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        int[] res = new int[k];
        for (int i = Math.max(0, k-m); i <= n && i <= k; i++) {          // 此处注意是元素个数所以是闭区间，不要忘记<=k!!!
            int[] candidate = Merge(MaxArray(nums1, i), MaxArray(nums2, k-i), k);
            if (greater(candidate, 0, res, 0)) res = candidate;
        }
        return res;
    }
    private int[] MaxArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; ++i) {    // i当前index，n-i为nums当前还剩下的元素，
            while ((n - i) + j > k && j > 0 && ans[j - 1] < nums[i]) j--; //j为当前已经加到ans的元素，k为需要的目标元素个数
            if (j < k) ans[j++] = nums[i];
        }
        return ans;
    }
    private int[] Merge(int[] arr1, int[]arr2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, curr = 0; curr < k; curr++)
        ans[curr] = greater(arr1, i, arr2, j) ? arr1[i++] : arr2[j++];
        return ans;
    }
    private boolean greater(int[] arr1, int i, int[] arr2, int j) {
        while (i < arr1.length && j < arr2.length && arr1[i] == arr2[j]) {
            i++; j++;
        }
        return j == arr2.length || (i < arr1.length && arr1[i] > arr2[j]);
    }
}