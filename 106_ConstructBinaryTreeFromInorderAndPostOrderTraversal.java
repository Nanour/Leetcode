// Sourse : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
// Date   : 2016-10-18

/***********************************************************************
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
　*　Note:
 * You may assume that duplicates do not exist in the tree.
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
    int pInorder;   // index of inorder array
    int pPostorder; // index of postorder array
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) return null;
        pInorder = inorder.length - 1;
	    pPostorder = postorder.length - 1;
	
	    return buildTree(inorder, postorder, null);
    }
    private TreeNode buildTree(int[] inorder, int[] postorder, TreeNode end) {
    	if (pPostorder < 0) {
    		return null;
    	}
    	
    	// create root node
    	TreeNode n = new TreeNode(postorder[pPostorder--]);
    	
    	// if right node exist, create right subtree
    	if (inorder[pInorder] != n.val) {
    		n.right = buildTree(inorder, postorder, n);
    	}
    	
    	pInorder--;
    	
    	// if left node exist, create left subtree
    	if ((end == null) || (inorder[pInorder] != end.val)) {
    		n.left = buildTree(inorder, postorder, end);
    	}
    	
    	return n;
    }
}