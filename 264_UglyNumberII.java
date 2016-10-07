// Sourse : https://leetcode.com/problems/ugly-number-ii/
// Date   : 2016-10-06

/***********************************************************************
 *
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number.
 *
 **********************************************************************/

// use long in case overflow

public class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        Queue<Long> heap = new PriorityQueue<>();
        heap.offer(1l);
        for (int i = 1; i < n; i++) {
            long curr = heap.poll();
            while(!heap.isEmpty() && heap.peek() == curr) {
                curr = heap.poll();
            }
            heap.offer(curr*2);
            heap.offer(curr*3);
            heap.offer(curr*5);
        }
        return heap.poll().intValue();
    }
}