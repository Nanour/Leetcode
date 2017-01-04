// Sourse : https://leetcode.com/problems/count-and-say/
// Date   : 2016-12-28

/***********************************************************************
 *
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 ***********************************************************************/

public class Solution {
    public String countAndSay(int n) {
        if (n == 0 || n == 1) {
            return "1";
        }
        String str = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length();) {
            int j = i;
            while (j+1 < str.length() && str.charAt(j) == str.charAt(j+1)) {
                j++;
            }
            sb.append(j-i+1);
            sb.append(str.charAt(i));
            i = j+1;
        }
        return sb.toString();
    }
}
