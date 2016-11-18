// Sourse : https://leetcode.com/problems/repeated-dna-sequences/
// Date   : 2016-11-17

/***********************************************************************
 *
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, 
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify 
 * repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that occur 
 * more than once in a DNA molecule.
 * 
 * For example,
 * 
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * 
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 **********************************************************************/

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) return new ArrayList<String>(); 
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i+10 <= s.length(); i++) {
            String curr = s.substring(i, i+10);
            if (!map.containsKey(curr)) {
                map.put(curr, 1);
            } else {
                map.put(curr, map.get(curr)+1);
                if (map.get(curr) == 2) {
                    res.add(curr);
                }
            }
        }
        return res;
    }
}