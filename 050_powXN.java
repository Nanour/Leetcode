// Sourse : https://leetcode.com/problems/powx-n/
// Date   : 2016-10-04

/***********************************************************************
 *
 * Implement pow(x, n).
 *
 **********************************************************************/

//eg. 10 = 1010 = 2^3 + 2^1 -> x^{10} = x^{2^3} * x^{2^1}

public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        //convert to long
        //Math.abs((int)-2147483648) = -2147483648
        //Math.abs((long)-2147483648) = 2147483648
        long N = Math.abs((long)n);
        double res = 1;
        while (N > 0) {
            if ((N & 1) == 1) {
                res *= x;
            }
            N >>= 1;
            x *= x;
        }
        return n > 0 ? res : 1/res;
    }
}