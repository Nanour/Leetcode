// Sourse : https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
// Date   : 2016-10-09

/***********************************************************************
 *
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * For example, Given s = “eceba” and k = 2,
 * T is "ece" which its length is 3.
 * 
 **********************************************************************/

// https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems/2


public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] hashmap = new int[128];
        char[] str = s.toCharArray();
        int slow = 0, fast = 0, count = 0, len = 0;
        while (fast < str.length) {
            if (hashmap[str[fast++]]++ == 0) {
                count++;
            }
            while (count > k) {
                if (hashmap[str[slow++]]-- == 1) {
                    count--;
                }
            }
            len = Math.max(len, fast-slow);
        }
        return len;
    }
}