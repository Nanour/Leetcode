// Sourse : https://leetcode.com/problems/excel-sheet-column-title/
// Date   : 2016-12-30

/***********************************************************************
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 * 
 *    1 -> A
 *    2 -> B
 *    3 -> C
 *    ...
 *    26 -> Z
 *    27 -> AA
 *    28 -> AB 
 *
 **********************************************************************/
// insert at the beginning
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }
}

// append then reverse
public class Solution {
    public String convertToTitle(int n) {
        List<Character> list = new ArrayList<Character>();
        int m = 26;
        while (n-- != 0) {
            list.add((char)('A'+(n%m)));
            n = n / 26;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size()-1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}