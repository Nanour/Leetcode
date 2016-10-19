// Sourse : https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
// Date   : 2016-10-18

/***********************************************************************
 *
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note:
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *          1
 *         /  \
 *        2    3
 *       / \    \
 *      4   5    7
 * After calling your function, the tree should look like:
 *         1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL
 *
 **********************************************************************/

// dummy.next指向每一层第一个元素
// 从root开始，将下一层元素用next指针串起来
// 按层遍历


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode dummy = new TreeLinkNode(0);
            TreeLinkNode curr = dummy;
            while (root != null) {
                if (root.left != null) {
                    curr.next = root.left;
                    curr = curr.next;
                }
                if (root.right != null) {
                    curr.next = root.right;
                    curr = curr.next;
                }
                root = root.next;
            }  
            root = dummy.next;
        }
    }
}