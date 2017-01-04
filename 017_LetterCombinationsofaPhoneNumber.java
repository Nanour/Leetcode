// Sourse : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// Date   : 2016-11-29

/***********************************************************************
 *
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * 
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 **********************************************************************/


// backtracking beats 39.85%

public class Solution {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" }; 
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        dfs(res, digits, 0, "");
        return res;
    }
    private void dfs(List<String> res, String digits, int start, String str) {
        if (start == digits.length()) {
            res.add(str);
            return;
        }
        String letters = KEYS[(digits.charAt(start))-'0'];
        for (int j = 0; j < letters.length(); j++) {
            dfs(res, digits, start+1, str + letters.charAt(j));
        }
    }
}