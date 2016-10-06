// Sourse : https://leetcode.com/problems/merge-k-sorted-lists/
// Date   : 2016-10-05

/***********************************************************************
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 **********************************************************************/

// heap
// O(knlogk) http://www.geeksforgeeks.org/merge-k-sorted-arrays/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static class compareListValue implements Comparator<ListNode> {
        public int compare(ListNode n1, ListNode n2) {
            return n1.val - n2.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        Comparator<ListNode> comp = new compareListValue();
        Queue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, comp);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        while (!pq.isEmpty()) {
            ListNode pollNode = pq.poll();
            if (pollNode.next != null) {
                pq.offer(pollNode.next);
            }
            curr.next = pollNode;
            curr = curr.next;
        }
        return dummy.next;
    }
}