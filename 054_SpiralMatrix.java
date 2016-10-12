// Sourse : https://leetcode.com/problems/spiral-matrix-ii/
// Date   : 2016-10-11

/***********************************************************************
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 **********************************************************************/


public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        
        if (matrix.length == 0) {
            return res;
        }
        
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            // Traverse Down
            for (int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (rowBegin <= rowEnd) {// Traverse Left
                for (int j = colEnd; j >= colBegin; j--) {
                    res.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }
            if (colBegin <= colEnd) {
                // Traverse Up
                for (int i = rowEnd; i >= rowBegin; i--) {
                    res.add(matrix[i][colBegin]);
                }
                colBegin++;   
            }
        }
        return res;
    }
}