// Sourse : https://leetcode.com/problems/binary-search-tree-iterator/
// Date   : 2016-11-23

/***********************************************************************
 *
 * Implement an iterator over a binary search tree (BST). Your iterator 
 * will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) 
 * memory, where h is the height of the tree.
 * 
 ***********************************************************************/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();          // 此处需注意如果next为null应当返回什么值
        TreeNode next = node.right;
        while (next != null) {
            stack.push(next);
            next = next.left;
        }
        return node.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */