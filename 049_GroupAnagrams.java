// Sourse : https://leetcode.com/problems/anagrams/
// Date   : 2016-12-28

/***********************************************************************
 *
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * Return:
 * 
 * [
 *  ["ate", "eat","tea"],
 *  ["nat","tan"],
 *  ["bat"]
 * ]
 * Note: All inputs will be in lower-case.
 * 
 ***********************************************************************/



public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) return res;
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;                   // return new ArrayList<List<String>>(map.values());
    }
}