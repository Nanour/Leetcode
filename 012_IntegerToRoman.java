// Sourse : https://leetcode.com/problems/integer-to-roman/
// Date   : 2016-10-05

/***********************************************************************
 *
 * MGiven an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 **********************************************************************/

// solution 1

public class Solution {
    public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10]; 
    }
}

// solution 2

public class Solution {
    public String intToRoman(int num) {
        int[] vals = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] strs = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; num > 0; i++) {
            while (num >= vals[i]) {
                sb.append(strs[i]);
                num -= vals[i];
            }
        }
        return sb.toString();
    }
}
 

