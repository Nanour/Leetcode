// Sourse : https://leetcode.com/problems/divide-two-integers/
// Date   : 2016-10-17

/***********************************************************************
 *
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 *
 **********************************************************************/


// 10 / 3
// 3 * 2 = 6, 1 * 2 = 2;
// 6 * 2 = 12 > 10 exit, count = 2
// dividend = 10 - 6 = 4;
// 3 * 2 = 6 > 4 exit, count = 1
// count = 2 + 1 = 3;

public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        int sign = (divisor < 0) ^ (dividend < 0) ? -1 : 1;
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long res = 0;
        while (absDividend >= absDivisor) {
            long temp = absDivisor, count = 1;
            while (temp <= absDividend) {
                temp <<= 1;
                count <<= 1;
            }
            res += count >> 1;
            absDividend -= temp >> 1;
        }
        return sign == 1 ? (int)res : (int)-res;
    }
}