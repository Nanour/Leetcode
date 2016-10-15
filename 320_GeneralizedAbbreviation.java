// Sourse : https://leetcode.com/problems/generalized-abbreviation/
// Date   : 2016-10-14

/***********************************************************************
 *
 * Write a function to generate the generalized abbreviations of a word.
 * Example:
 * Given word = "word", return the following list (order does not matter):
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 *
 **********************************************************************/

public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        backtracking(word, res, "", 0, 0);
        return res;
    }
    private void backtracking(String word, List<String> res, String temp, int count, int start) {
        if (start == word.length()) {
            if (count > 0) {
                temp += count;
            }
            res.add(temp);
            return ;
        }
        backtracking(word, res, temp, count+1, start+1);
        backtracking(word, res, temp+(count > 0? count : "")+word.charAt(start), 0, start+1);
    }
}