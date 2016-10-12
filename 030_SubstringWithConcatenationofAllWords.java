// Sourse : https://leetcode.com/problems/substring-with-concatenation-of-all-words/
// Date   : 2016-10-10

/***********************************************************************
 *
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 * 
 **********************************************************************/

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        HashMap<String, Integer> target = new HashMap<String, Integer>();
        HashMap<String, Integer> found = new HashMap<String, Integer>();
        int m = words.length, wordLength = words[0].length();
        for (String word : words){
            target.put(word, target.getOrDefault(word,0)+1);
        }
        for (int i = 0; i <= s.length() - wordLength*m; i++) {
            found.clear();
            int j;
            for (j = 0; j < m; j++) {
                int k = i + j * wordLength;
                String curr = s.substring(k, k+wordLength);
                if (!target.containsKey(curr)) {
                    break;
                }
                found.put(curr, found.getOrDefault(curr,0)+1);
                if (found.get(curr) > target.get(curr)) {
                    break;
                }
            }
            if (j == m) {
                res.add(i);
            }
        }
        return res;
    }
}