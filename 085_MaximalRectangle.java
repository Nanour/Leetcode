// Sourse : https://leetcode.com/problems/maximal-rectangle/
// Date   : 2016-10-19

/***********************************************************************
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * 
 *  For example, given the following matrix:
 *  1 0 1 0 0
 *  1 0 1 1 1
 *  1 1 1 1 1
 *  1 0 0 1 0
 *  Return 6.
 *
 **********************************************************************/

// left[j] is j left boundary
// right[j] is j right boundary
// height[j] is j height
// area = (right[j]-left[j])*height[j]
// **Note: need to consider '''last row'''
// For example:
// matrix[2][1] if not consider last row, the area will be (6-1)*3  which is wrong
// Consider last row, res[i][j] is not the area of i,j. But the upbound area can be guarantee.

// 11ms

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if((matrix == null) || (matrix.length == 0)) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        Arrays.fill(right, n);
        int max = 0;
        for (int i = 0; i < m; i++) {
            int currLeft = 0, currRight = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') left[j] = Math.max(left[j], currLeft);
                else { 
                    left[j] = 0;
                    currLeft = j + 1;
                }
            }
            for (int j = n-1; j >= 0; j--) {
                if (matrix[i][j] == '1') right[j] = Math.min(right[j], currRight);
                else {
                    right[j] = n;
                    currRight = j;
                }
            }
            for (int j = 0; j < n; j++) {
                max = Math.max(max, (right[j]-left[j])*height[j]);
            }
        }
        return max;
    }
}