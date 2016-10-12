// Sourse : https://leetcode.com/problems/spiral-matrix-ii/
// Date   : 2016-10-11

/***********************************************************************
 *
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * 
 **********************************************************************/


public class Solution {
    public int[][] generateMatrix(int n) {
        int len = n, count = len/2, val = 1;
        int[][] matrix = new int[n][n];
        for (int start = 0; count > 0; count--, start++) {
            int i = start, j = start;
            while (j < len-start-1) {
                matrix[i][j++] = val++;
            }
            while (i < len-start-1) {
                matrix[i++][j] = val++;
            }
            while (j > start) {
                matrix[i][j--] = val++;
            }
            while (i > start) {
                matrix[i--][j] = val++;
            }
        }
        if (n%2 != 0) {
            matrix[n/2][n/2] = val++;
        }
        return matrix; 
    }
}