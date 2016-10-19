// Sourse : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// Date   : 2016-10-18

/***********************************************************************
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 **********************************************************************/

// 有两个array， PRE和IN
// PRE[0] 是根节点， 在IN中找这个点，假如是IN[5]，则IN[5]是根节点，并且IN[5]之前的点在左边，之后的点在右边


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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, preorder.length-1, inorder.length - 1, preorder, inorder);
    }
    private TreeNode helper(int preStart, int inStart, int preEnd, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int i = inStart;
        while (inorder[i] != root.val) {
            i++;
        }
        root.left = helper(preStart + 1, inStart, preEnd, i - 1, preorder, inorder);
        root.right = helper(preStart + (i-inStart) + 1, i + 1, preEnd, inEnd, preorder, inorder);
        return root;
    }
}