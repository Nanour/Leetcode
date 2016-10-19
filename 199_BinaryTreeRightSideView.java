// Sourse : https://leetcode.com/problems/binary-tree-right-side-view/
// Date   : 2016-10-18

/***********************************************************************
 *
 * Given a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * For example:
 * Given the following binary tree,
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * You should return [1, 3, 4].
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res, int depth) {
        if (root == null) {
            return ;
        }
        if (depth == res.size()) {
            res.add(root.val);
        }
        helper(root.right, res, depth+1);
        helper(root.left, res, depth+1);
    }
}