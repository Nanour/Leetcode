// Sourse : https://leetcode.com/problems/copy-list-with-random-pointer/
// Date   : 2016-10-05

/***********************************************************************
 *
 * A linked list is given such that each node contains an additional random 
 * pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 *
 **********************************************************************/

// solution1 : HashMap

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> hm = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode curr = dummy;
        while (head != null) {
            RandomListNode newNode;
            if (hm.containsKey(head)) {
                newNode = hm.get(head);
            } else {
                newNode = new RandomListNode(head.label);
                hm.put(head, newNode);
            }
            curr.next = newNode;
            if (head.random != null) {
                if (hm.containsKey(head.random)) {
                    newNode.random = hm.get(head.random);
                } else {
                    newNode.random = new RandomListNode(head.random.label);
                    hm.put(head.random, newNode.random);
                }
            }
            curr = curr.next;
            head = head.next;
        }
        return dummy.next;
    }
}


// solution2 : add random pointer next to each node