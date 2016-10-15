// Sourse : https://leetcode.com/problems/palindrome-permutation-ii/
// Date   : 2016-10-14

/***********************************************************************
 *
 * Given a string s, return all the palindromic permutations (without duplicates) of it. 
 * Return an empty list if no palindromic permutation could be form.
 * For example:
 * Given s = "aabb", return ["abba", "baab"].
 * Given s = "abc", return [].
 *
 **********************************************************************/

// 如果string不能组成parlindrome返回false
// 如果能组成，先将一半的char组成permutations，然后temp+mid+temp.reverse  7ms

public class Solution {
    public List<String> generatePalindromes(String s) {
        int odd = 0;
        String mid = "";
        List<String> res = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
    
        // step 1. build character count map and count odds
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
            odd += map.get(c) % 2 != 0 ? 1 : -1;
        }
    
        // cannot form any palindromic string
        if (odd > 1) return res;
    
        // step 2. add half count of each character to list
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
    
            if (val % 2 != 0) mid += key;
    
            for (int i = 0; i < val / 2; i++) list.add(key);
        }
    
        // step 3. generate all the permutations
        getPerm(list, mid, new boolean[list.size()], new StringBuilder(), res);
    
        return res;
    }
    
    // generate all unique permutation from list
    void getPerm(List<Character> list, String mid, boolean[] used, StringBuilder sb, List<String> res) {
        if (sb.length() == list.size()) {
            // form the palindromic string
            res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }
    
        for (int i = 0; i < list.size(); i++) {
            // avoid duplication
            if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue;
    
            if (!used[i]) {
                used[i] = true; sb.append(list.get(i));
                // recursion
                getPerm(list, mid, used, sb, res);
                // backtracking
                used[i] = false; sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}


// brute force TLE  

public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<String>();
        backtracking(res, "", new boolean[s.length()], s);
        return res;
    }
    private void backtracking(List<String> res, String temp, boolean[] used, String s) {
        if (temp.length() == s.length()) {
            if (isPalindrome(temp) && !res.contains(temp)) {
                res.add(temp);
            }
            return ;
        }
        for (int i = 0; i < s.length(); i++) {
            if (used[i] == true) continue;
            used[i] = true;
            temp += s.charAt(i);
            backtracking(res, temp, used, s);
            used[i] = false;
            temp = temp.substring(0, temp.length()-1);
        }
    }
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}