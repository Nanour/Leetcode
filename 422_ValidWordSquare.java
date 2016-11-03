// Sourse : https://leetcode.com/problems/valid-word-square/
// Date   : 2016-11-01

/***********************************************************************
 *
 * Given a sequence of words, check whether it forms a valid word square.
 * 
 * A sequence of words forms a valid word square if the kth row and column 
 * read the exact same string, where 0 ≤ k < max(numRows, numColumns).
 * 
 * Note:
 * The number of words given is at least 1 and does not exceed 500.
 * Word length will be at least 1 and does not exceed 500.
 * Each word contains only lowercase English alphabet a-z.
 *
 **********************************************************************/

public class Solution {
    public boolean validWordSquare(List<String> words) {
        for(int i = 0 ; i < words.size(); i++) {
            String str = words.get(i);
            for (int j = 0; j < words.size() && j < str.length();j++) {
                if(words.get(j).length() <= i || str.length() > words.size())
                    return false;
                if(str.charAt(j) != words.get(j).charAt(i))
                    return false;
            }
        }
        return true;
    }
}