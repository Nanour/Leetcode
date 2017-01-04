// Sourse : https://leetcode.com/problems/binary-tree-paths/
// Date   : 2016-12-27

/***********************************************************************
 *
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * For example, given the following binary tree:
 * 
 *   1
 * /   \
 * 2     3
 * \
 *  5
 * All root-to-leaf paths are:
 * 
 * ["1->2->5", "1->3"]
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

// StringBuilder

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<String>();
        if (root == null) return res;
        dfs(res, new StringBuilder(), root);
        return res;
    }
    
    private void dfs(List<String> res, StringBuilder sb, TreeNode node) {
        if (node.left == null && node.right == null) {
            res.add(sb.append(node.val).toString());
            return;
        }
        int len = sb.length();
        if (node.right != null) {
            dfs(res, sb.append(node.val).append("->"), node.right);
            sb.setLength(len);
        } 
        if (node.left != null) {
            dfs(res, sb.append(node.val).append("->"), node.left);
            sb.setLength(len);
        }   
    }
}

// String
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) searchBT(root, "", answer);
        return answer;
    }
    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
        if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
    }
}