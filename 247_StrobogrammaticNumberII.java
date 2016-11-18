// Sourse : https://leetcode.com/problems/strobogrammatic-number-ii/
// Date   : 2016-11-17

/***********************************************************************
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Find all strobogrammatic numbers that are of length = n.
 * 
 * For example,
 * Given n = 2, return ["11","69","88","96"].
 * 
 **********************************************************************/

public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    private List<String> helper(int n, int m) {
        if (n == 0) return new ArrayList<String>(Arrays.asList(""));
        if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        
        List<String> preList = helper(n-2, m);
        
        List<String> res = new ArrayList<>();
        for (String s : preList) {
            if (n != m) res.add("0" + s + "0");
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }
}