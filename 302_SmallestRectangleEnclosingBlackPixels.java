// Sourse : https://leetcode.com/problems/smallest-rectangle-enclosing-black-pixels/
// Date   : 2016-11-03

/***********************************************************************
 *
 * An image is represented by a binary matrix with 0 as a white pixel and 1 
 * as a black pixel. The black pixels are connected, i.e., there is only one 
 * black region. Pixels are connected horizontally and vertically. Given the 
 * location (x, y) of one of the black pixels, return the area of the smallest 
 * (axis-aligned) rectangle that encloses all black pixels.
 * 
 * For example, given the following image:
 * 
 * [
 *  "0010",
 *  "0110",
 *  "0100"
 * ]
 * and x = 0, y = 2,
 * Return 6.
 *
 ***********************************************************************/

// O(mlogn + nlogm)  1ms

public class Solution {
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 
            || image[0] == null || image[0].length == 0) return 0;
        int m = image.length, n = image[0].length;
        int left = binarySearchCol(0, y, 0, m, image, true);
        int right = binarySearchCol(y+1, n, 0, m, image, false);
        int top = binarySearchRow(0, x, left, right, image, true);
        int bottom = binarySearchRow(x+1, m, left, right, image, false);
        return (right-left) * (bottom-top);
    }
    private int binarySearchCol(int left, int right, int top, int bottom, char[][] image, boolean isLeftBoundary) {
        while (left < right) {
            int mid = left + (right-left)/2;
            int count = top;
            while (count < bottom && image[count][mid] == '0') count++;
            if ((count < bottom) == isLeftBoundary) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private int binarySearchRow(int left, int right, int top, int bottom, char[][] image, boolean isTopBoundary) {
        while (left < right) {
            int mid = left + (right-left)/2;
            int count = top;
            while (count < bottom && image[mid][count] == '0') count++;
            if ((count < bottom) == isTopBoundary) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
}


// O(n^2) TLE

public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int[] sum = new int[image.length];
        int max = -1;
        for (int i = 0; i < image.length; i++) {
            for (char j : image[i]) {
                sum[i] += j-'0';
            }
            max = Math.max(max, sum[i]);
        }
        int start = -1, end = -1;
        for (int i = 0; i < sum.length; i++) {
            if (start == -1 && sum[i] != 0) {
                start = i;
            }
        }
        for (int i = sum.length-1; i >= 0; i++) {
            if (end == -1 && sum[i] != 0) {
                end = i;
            }
        }
        return max * (end-start+1);
    }
}

