// Sourse : https://leetcode.com/problems/rotate-image/
// Date   : 2016-10-12

/***********************************************************************
 *
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 *
 **********************************************************************/

// clockwise -> revese vertically -> reverse diagnoally
// anti-clockwise -> reverse horizontolly -> reverse diagnoally

// solution1 2ms
public class Solution {
    public void rotate(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}

// solution2 3ms
public class Solution {
    public void rotate(int[][] matrix) {
        int start = 0, end = 0, len = matrix.length, count = len/2;
        for (int i = 0; i < count; i++) {
            start = i;
            end = start;
            for (int j = start; j < len-start-1; j++) {
                swap(matrix, i, j, end++, len-start-1);
            }
            end = len-start-1;
            for (int j = start; j < len-start-1; j++) {
                swap(matrix, i, j, len-start-1, end--);
            }
            end = len-start-1;
            for (int j = start; j < len-start-1; j++) {
                swap(matrix, i, j, end--, start);
            }
        }
    }
    private void swap(int[][] matrix, int i, int j, int ni, int nj) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[ni][nj];
        matrix[ni][nj] = temp;
    }
}