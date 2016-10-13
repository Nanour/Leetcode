// Sourse : https://leetcode.com/problems/palindrome-partitioning/
// Date   : 2016-10-12

/***********************************************************************
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return
 * [
 *  ["aa","b"],
 *  ["a","a","b"]
 * ]
 *
 **********************************************************************/


public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        backtracking(res, s, new ArrayList<String>(), 0);
        return res;
    }
    private void backtracking(List<List<String>> res, String s, ArrayList<String> path, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(path));
            return ;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                path.add(s.substring(start, i+1));
                backtracking(res, s, path, i+1);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}