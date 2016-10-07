// Sourse : https://leetcode.com/problems/longest-palindrome/
// Date   : 2016-10-06

/***********************************************************************
 *
 * Given a string which consists of lowercase or uppercase letters, find the 
 * length of the longest palindromes that can be built with those letters.
 * Input:
 * "abccccdd"
 * Output:
 * 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 **********************************************************************/

public class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
       Set<Character> hs = new HashSet<>();
       char[] letters = s.toCharArray();
       int res = 0;
       for (char letter : letters) {
           if (hs.contains(letter)) {
               res++;
               hs.remove(letter);
           } else {
               hs.add(letter);
           }
       }
       return hs.isEmpty() ? res*2 : res*2+1;
    }
}