// Sourse : https://leetcode.com/problems/closest-binary-search-tree-value-ii/
// Date   : 2016-11-25

/***********************************************************************
 *
 * Given a non-empty binary search tree and a target value, find k values 
 * in the BST that are closest to the target.
 * 
 * Note:
 * Given target value is a floating point.
 * You may assume k is always valid, that is: k ≤ total nodes.
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 *
 **********************************************************************/


// inorder 遍历得到升序序列， reverse inorder序列得到降序
// 两个stk各存储一半的值，再merge两个stk得到k个closest值


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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();

        Stack<Integer> predecessors = new Stack<>(); // predecessors
        Stack<Integer> successors = new Stack<>(); // successors
        
        inorder(root, target, false, predecessors);    // 升序
        inorder(root, target, true, successors);       // 降序
        
        while (k-- > 0) {
            if (predecessors.isEmpty())
              res.add(successors.pop());
            else if (successors.isEmpty())
              res.add(predecessors.pop());
            else if (Math.abs(predecessors.peek() - target) < Math.abs(successors.peek() - target))
              res.add(predecessors.pop());
            else
              res.add(successors.pop());
        }
        return res;
    }
    
    private void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stk) {
        if (root == null) return;

        inorder(reverse ? root.right : root.left, target, reverse, stk);
        if ((reverse && root.val <= target) || (!reverse && root.val > target)) return;
        stk.push(root.val);
        inorder(reverse ? root.left : root.right, target, reverse, stk);
    }
}