// Sourse : https://leetcode.com/problems/integer-replacement/
// Date   : 2016-11-25

/***********************************************************************
 *
 * Given a positive integer n and you can do operations as follow:
 * 
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * What is the minimum number of replacements needed for n to become 1?
 *
 **********************************************************************/

// even数字只能除2， odd数字有两种方式
// 为了使得更多的除法，所以判断n+1 和 n-1哪个数字可以除以4
// 其中3是例外

// 证明 https://discuss.leetcode.com/topic/58425/java-12-line-4-5-ms-iterative-solution-with-explanations-no-other-data-structures/4



public class Solution {
    public int integerReplacement(int n) {
        if(n == Integer.MAX_VALUE) return 32; //n = 2^31-1;
        int count = 0;
        while (n > 1) {
            if (n % 2 == 0) { 
                n >>>= 1;
            } else if ((n+1) % 4 == 0 && n != 3){
                n++;
            } else {
                n--;
            }
            count++;
        }
        return count;
    }
}