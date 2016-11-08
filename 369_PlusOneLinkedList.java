// Sourse : https://leetcode.com/problems/plus-one-linked-list/
// Date   : 2016-11-07

/***********************************************************************
 *
 * Given a non-negative number represented as a singly linked list of digits, plus one to the number.
 * 
 * The digits are stored such that the most significant digit is at the head of the list.
 ***********************************************************************/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        if (head == null) return head;
        head = reverse(head); 
        ListNode curr = null;
        curr = head;
        int carry = 1;
        while (curr != null && curr.next != null) {
            int sum = curr.val + carry;
            curr.val = sum % 10;
            carry = sum / 10;
            System.out.println(curr.val);
            curr = curr.next;
        }
        int sum = curr.val + carry;

        curr.val = sum % 10;
        carry = sum / 10;
        System.out.println(curr.val + " " + carry);
        if (carry != 0) {
            ListNode newHead = new ListNode(carry);
            curr.next = newHead;
        }
        return reverse(head);
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