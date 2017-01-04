// Sourse : https://leetcode.com/problems/reverse-nodes-in-k-group/
// Date   : 2016-12-31

/***********************************************************************
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example,
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 *
 **********************************************************************/

// iterative
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy, tail = dummy;
        
        while (tail.next != null) {
            int count = 0;
            for (int i = 0; i < k; i++) {
                if (tail.next != null) {
                    tail = tail.next;
                    count++;
                } 
            }
            if (count == k) {
                ListNode temp = tail.next;
                tail.next = null;
                ListNode reverseList = reverse(curr.next);
                curr.next = reverseList;
                while (reverseList.next != null) {
                    reverseList = reverseList.next;
                }
                reverseList.next = temp;
                curr = reverseList;
                tail = reverseList;
            }
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}
// recursive
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { 
            curr = curr.next;
            count++;
        }
        if (count == k) { 
            curr = reverseKGroup(curr, k); // head是需要reverse的最开始，curr是后面一串，即当前需要reverse的结尾
            while (count-- > 0) {  
                ListNode tmp = head.next; 
                head.next = curr; 
                curr = head; 
                head = tmp;
            }
            head = curr;
        }
        return head;
    }
}