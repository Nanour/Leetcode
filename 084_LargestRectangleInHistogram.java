// Sourse : https://leetcode.com/problems/largest-rectangle-in-histogram/
// Date   : 2016-10-20

/***********************************************************************
 *
 * Given n non-negative integers representing the histogram's bar height 
 * where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 **********************************************************************/
// 在最后一个bar后面加上0
// 如果当前bar高度高于之前的，push到stk，否则pop出计算面积
// i是右边界，stk.peek（）是左边界，如果stk是空，左边界为i

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<Integer>();
        int len = heights.length;
        int max = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : heights[i]);
            if (stk.isEmpty() || h >= heights[stk.peek()]) {
                stk.push(i);
            } else {
                int top = stk.pop();
                max = Math.max(max, heights[top] * (stk.isEmpty() ? i : i-1-stk.peek()));
                i--;
            }
        }
        return max;
    }
}