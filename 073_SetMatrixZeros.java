// Sourse : https://leetcode.com/problems/set-matrix-zeroes/
// Date   : 2016-10-31

/***********************************************************************
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. 
 * Do it in place.
 *
 **********************************************************************/

// store states of each row in the first of that row, and store states of each column in the first of that column. 
// because the state of row0 and the state of column0 would occupy the same cell, 
// let it be the state of row0, and use another variable "col0" for column0. 


public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, col0 = 1;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if (col0 == 0) matrix[i][0] = 0;
        }
    }
}