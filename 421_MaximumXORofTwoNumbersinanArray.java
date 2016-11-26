// Sourse : https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
// Date   : 2016-11-25

/***********************************************************************
 *
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 * 
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * 
 * Could you do this in O(n) runtime?
 *
 **********************************************************************/

// Orz.....

// !!! If a^b=c, then a^c=b, b^c=a.

public class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);                        // 每次只保留最高位，忽略低位
            HashSet<Integer> set = new HashSet<Integer>();
            for (int num : nums) {
                set.add(num & mask);                 // 数组中每次可能的值
            }
            int temp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(temp ^ prefix)) {        // 找到set中是否有可以组成max的pair
                    max = temp;
                }
            }
        }
        return max;
    }
}