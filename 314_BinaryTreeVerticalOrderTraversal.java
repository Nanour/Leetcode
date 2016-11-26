// Sourse : https://leetcode.com/problems/shortest-palindrome/
// Date   : 2016-11-25

/***********************************************************************
 *
 * Given a binary tree, return the vertical order traversal of its nodes' 
 * values. (ie, from top to bottom, column by column).
 * 
 * If two nodes are in the same row and column, the order should be from left to right.
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        
        nodes.add(root); 
        cols.add(0);
    
        int min = 0, max = 0;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            int col = cols.poll();
            
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>());
            }
            map.get(col).add(node.val);
    
            if (node.left != null) {
                nodes.add(node.left); 
                cols.add(col - 1);
                min = Math.min(min, col - 1);
            }
            
            if (node.right != null) {
                nodes.add(node.right);
                cols.add(col + 1);
                max = Math.max(max, col + 1);
            }
        }
    
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
    
        return res;
    }
}