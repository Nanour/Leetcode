// Sourse : https://leetcode.com/problems/missing-number/
// Date   : 2016-10-31

/***********************************************************************
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 **********************************************************************/

// XOR
public class Solution {
    public int missingNumber(int[] nums) { //xor
        int res = nums.length;
        for(int i = 0; i < nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
}

// SUM
public class Solution {
    public int missingNumber(int[] nums) { //sum
        int len = nums.length;
        int sum = (0+len)*(len+1)/2;
        for(int i = 0; i < len; i++)
            sum -= nums[i];
        return sum;
    }
}

//Binary Search
public class Solution {
    public int missingNumber(int[] nums) { //binary search
        Arrays.sort(nums);
        int left = 0, right = nums.length, mid= (left + right)/2;
        while(left < right){
            mid = (left + right)/2;
            if(nums[mid] > mid) right = mid;
            else left = mid+1;
        }
        return left;
    }
}