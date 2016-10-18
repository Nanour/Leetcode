// Sourse : https://leetcode.com/problems/word-break-ii/
// Date   : 2016-10-15

/***********************************************************************
 *
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 *
 **********************************************************************/

// 记忆化搜索，用一个map记录之前搜索过的值，避免重复搜索 17ms

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        return backtracking(s, wordDict, new HashMap<String, List<String>>());
    }
    private List<String> backtracking(String s, Set<String> wordDict, HashMap<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> res = new ArrayList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (int i = 0; i < s.length(); i++) {
            String word = s.substring(0, i+1);
            if (wordDict.contains(word)) {
                List<String> subLists = backtracking(s.substring(i+1), wordDict, map);
                for (String sub : subLists) {
                    res.add(word + (sub.length()==0 ? "" : " ") + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}

// backtracking brute force会超时  TLE

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        backtracking(res, "", s, wordDict, 0);
        return res;
    }
    private void backtracking(List<String> res, String temp, String s, Set<String> wordDict, int start) {
        if (start == s.length() && temp.length() != 0) {
            res.add(temp);
            return ;
        }
        if (start < s.length()) {
            for (int i = start; i < s.length(); i++) {
                if (wordDict.contains(s.substring(start, i+1))) {
                    String str = temp;
                    if (start != 0) temp += " "; 
                    temp += s.substring(start, i+1);
                    backtracking(res, temp, s, wordDict, i+1);
                    temp = str;
                }
            }
        }
    }
}
