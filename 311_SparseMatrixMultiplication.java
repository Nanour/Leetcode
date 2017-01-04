// Sourse : https://leetcode.com/problems/sparse-matrix-multiplication/
// Date   : 2016-11-29

/***********************************************************************
 *
 * Given two sparse matrices A and B, return the result of AB.
 * 
 * You may assume that A's column number is equal to B's row number.
 * 
 * Example:
 * 
 * A = [
 *  [ 1, 0, 0],
 *  [-1, 0, 3]
 * ]
 * 
 * B = [
 *  [ 7, 0, 0 ],
 *  [ 0, 0, 0 ],
 *  [ 0, 0, 1 ]
 * ]
 * 
 * 
 *      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 *                   | 0 0 1 |
 **********************************************************************/

// 稀疏矩阵乘法，压缩每个矩阵，只保留非零值
// 只计算两个矩阵中数字都为0的值

public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, colA = A[0].length, n = B[0].length;
        int[][] C = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < colA; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < n; j++) {
                        if (B[k][j] != 0) C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return C;
    }
}

// 先preprocess矩阵，压缩稀疏矩阵， 压缩其中一个矩阵

public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, colA = A[0].length, n = B[0].length;
        int[][] C = new int[m][n];
        
        List[] indexA = new List[m];
        for(int i = 0; i < m; i++) {
            List<Integer> numsA = new ArrayList<>();
            for(int j = 0; j < colA; j++) {
                if(A[i][j] != 0){
                    numsA.add(j); 
                    numsA.add(A[i][j]);
                }
            }
            indexA[i] = numsA;
        }

        for (int i = 0; i < m; i++) {
            List<Integer> numsA = indexA[i];
            for (int k = 0; k < numsA.size(); k += 2) {
                int col = numsA.get(k);
                int valA = numsA.get(k + 1);
                for(int j = 0; j < n; j ++) {
                    int valB = B[col][j];
                    C[i][j] += valA * valB;
                }
            }
        }
        return C;
    }
}