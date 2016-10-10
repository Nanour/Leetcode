// Sourse : https://leetcode.com/problems/minimum-window-substring/
// Date   : 2016-10-09

/***********************************************************************
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * 
 **********************************************************************/

// https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems/12

// Two pointers
// map存储每个字符出现的次数
// fast每遇到一个符合的字符从map中--，同时count++；
// 当找到包含所有target字符的string，求len
// slow每遇到一个字符加回map++，如果大于0，说明扔掉了一个符合的字符，count--；

public class Solution {
    public String minWindow(String s, String t) {
        int[] hashmap = new int[128];
        char[] source = s.toCharArray();
        char[] target = t.toCharArray();
        for (char c : target) {
            hashmap[c]++;
        }
        int slow = 0, fast = 0, count = 0, start = 0, len = Integer.MAX_VALUE;
        String res = "";
        while (fast < source.length) {
            if (hashmap[source[fast++]]-- > 0) {
                count++;
            }
            while (count == target.length) {
                if (len > (fast-slow)) {
                    len = fast-slow;
                    start = slow;
                    res = s.substring(slow, fast);         // [slow,fast)
                }
                if (++hashmap[source[slow++]] > 0) {
                    count--;
                }
            }
        }
        return res;
    }
}


// more readabel version

public class Solution {
    public String minWindow(String s, String t) {
        int[] hashmap = new int[256];
        char[] source = s.toCharArray();
        char[] target = t.toCharArray();
        for (char c : target) {
            hashmap[c]++;
        }
        int slow = 0, fast = 0, count = 0, start = 0, len = Integer.MAX_VALUE;
        String res = "";
        while (fast < source.length) {
            if (hashmap[source[fast]] > 0) {
                count++;
            }
            hashmap[source[fast]]--;
            fast++;
            while (count == target.length) {
                if (len > (fast-slow)) {
                    len = fast-slow;
                    start = slow;
                    res = s.substring(slow, fast);         // [slow,fast)
                }
                ++hashmap[source[slow]];
                if (hashmap[source[slow]] > 0) {
                    count--;
                }
                slow++;
            }
        }
        return res;
    }
}

