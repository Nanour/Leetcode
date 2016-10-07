// Sourse : https://leetcode.com/problems/shortest-word-distance/
// Date   : 2016-10-06

/***********************************************************************
 *
 * Given a list of words and two words word1 and word2, return the shortest 
 * distance between these two words in the list.
 * 
 * A word can appear several times:
 * ["a","c","b","a"]
 * "a"
 * "b"
 * Distance should be 1
 * 
 **********************************************************************/

public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE, index1 = -1, index2 = -1;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                index1 = i; 
                if(index2 >= 0) {
                    res = Math.min(res, i - index2);
                }
            } else if(words[i].equals(word2)) {
                index2 = i;
                if(index1 >= 0) {
                    res = Math.min(res, i - index1);
                }
            }
        }
        return res;
    }
}