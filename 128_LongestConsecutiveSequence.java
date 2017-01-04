// Sourse : https://leetcode.com/problems/longest-consecutive-sequence/
// Date   : 2016-12-29

/***********************************************************************
 *
 * Given an unsorted array of integers, find the length of the longest 
 * consecutive elements sequence.
 * 
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 ***********************************************************************/


public class Solution {
   public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums){
                set.add(num);
            }
            int max = 0, count = 0;
            for (int val : nums){
                count = 0;
                if (!set.contains(val + 1)){
                    while(set.remove(val--)){
                        count++;
                    }
                    max = Math.max(count , max);
                }
            }
            return max;
        }
}