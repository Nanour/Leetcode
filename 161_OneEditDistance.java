// Sourse : https://leetcode.com/problems/one-edit-distance/
// Date   : 2016-10-20

/***********************************************************************
 *
 * Given two strings S and T, determine if they are both one edit distance apart.
 *
 **********************************************************************/

/*
 * There're 3 possibilities to satisfy one edit distance apart: 
 * 
 * 1) Replace 1 char in s:
 	  s: a B c
 	  t: a D c
 * 2) Delete 1 char from s: 
	  s: a D  b c
	  t: a    b c
 * 3) Insert 1 char to s:
	  s: a   b c
	  t: a D b c
 */

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) == t.charAt(i)) continue;
            if (s.length() == t.length()) {
                return s.substring(i+1).equals(t.substring(i+1)); 
            } else if (s.length() > t.length()) {
                return s.substring(i+1).equals(t.substring(i));
            } else {
                return s.substring(i).equals(t.substring(i+1));
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}