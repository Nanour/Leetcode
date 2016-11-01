// Sourse : https://leetcode.com/problems/median-of-two-sorted-arrays/
// Date   : 2016-10-31

/***********************************************************************
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 **********************************************************************/

// O(log(m+n)) binary search
// array A, and array B
// for A have cut 0...i, B have cut 0...j
// find i, j when i+j = (m+n+1)/2 && A[i-1] <= B[j] && B[j-1] <= A[i]

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        if (m == 0) return ((double)nums2[n/2] + (double)nums2[(n-1)/2])/2;
        int low = 0, high = m, i = 0, j = 0;
        while (low <= high) {
            i = low + (high-low)/2;
            j = (m+n+1)/2 - i;
            if (i > 0 && j < n && nums1[i-1] > nums2[j]) {
                high = i - 1;   
            } else if (i < m && j > 0 && nums2[j-1] > nums1[i]) {
                low = i + 1;
            } else {
                break;
            }
        }
        int maxLeft = (i != 0 && j != 0) ? Math.max(nums1[i-1], nums2[j-1]) : (i != 0 ? nums1[i-1] : nums2[j-1]);
        if ((m+n) % 2 == 1) return maxLeft;
        int minRight = (i != m && j != n) ? Math.min(nums1[i], nums2[j]) : (i != m ? nums1[i] : nums2[j]);
        return (double)(maxLeft + minRight) / 2;
    }
}

/*  
  nums1: A[0] ~ A[i-1]  |  A[i] ~ A[m]
  nums2: B[0] ~ B[j-1]  |  B[j] ~ B[n]   
*/
