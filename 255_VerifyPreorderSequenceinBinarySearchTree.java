// Sourse : https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/
// Date   : 2016-11-07

/***********************************************************************
 *
 * Given an array of numbers, verify whether it is the correct preorder 
 * traversal sequence of a binary search tree.
 * 
 * You may assume each number in the sequence is unique.
 *
 ***********************************************************************/

public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int currMin = Integer.MIN_VALUE;
        Stack<Integer> stk = new Stack();
        for (int p : preorder) {
            if (p < currMin) {
                return false;
            }
            while (!stk.empty() && p > stk.peek()) {
                currMin = stk.pop();
            }
            stk.push(p);
        }
        return true;
    }
}