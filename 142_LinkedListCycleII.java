// Sourse : https://leetcode.com/problems/linked-list-cycle/
// Date   : 2016-10-27

/***********************************************************************
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Note: Do not modify the linked list.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 *
 **********************************************************************/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                fast = head;
                while (slow.next != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return null;
    }
}