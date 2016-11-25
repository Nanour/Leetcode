// Sourse : https://leetcode.com/problems/nth-digit/
// Date   : 2016-11-24

/***********************************************************************
 *
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * 
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 *
 **********************************************************************/

// start是每次的起点，假设n=15，start为10，10的step是2，所以相当于多加了一位，因此n-1。
// 同时要保证nth digit落在计算后的start中，n-1保证了当n可以整除step时，不多进一位。


public class Solution {
    public int findNthDigit(int n) {
        long count = 9;
        int step = 1, start = 1;
        while (n > count*step) {
            n -= count * step;
            count *= 10;
            step += 1;
            start *= 10;
        }
        start += (n-1) / step;
        String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % step));
    }
}