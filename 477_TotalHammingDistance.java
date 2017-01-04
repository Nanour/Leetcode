// Sourse : https://leetcode.com/problems/total-hamming-distance/
// Date   : 2016-12-30

/***********************************************************************
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * 
 * Now your job is to find the total Hamming distance between all pairs of the given numbers.
 **********************************************************************/

public class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            for (int num : nums) {
                bitCount += (num >> i) & 1;
            }
            total += bitCount * (n-bitCount);
        }
        return total;
    }
}