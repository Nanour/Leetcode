// Sourse : https://leetcode.com/problems/count-complete-tree-nodes/
// Date   : 2016-11-01

/***********************************************************************
 *
 * Given a complete binary tree, count the number of nodes.
 * 
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, 
 * and all nodes in the last level are as far left as possible. It can have between 1 and 
 * 2h nodes inclusive at the last level h.
 *
 **********************************************************************/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftCount = 0, rightCount = 0;
        TreeNode left = root, right = root;
        while (left != null) {
            leftCount++;
            left = left.left;
        } 
        while (right != null) {
            rightCount++;
            right = right.right;
        }
        if (leftCount == rightCount) {
            return (1<<leftCount)-1;
        } else {
            return 1  + countNodes(root.left) + countNodes(root.right);
        }
    }
}