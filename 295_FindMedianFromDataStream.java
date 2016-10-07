// Sourse : https://leetcode.com/problems/find-median-from-data-stream/
// Date   : 2016-10-06

/***********************************************************************
 *
 * Median is the middle value in an ordered integer list. 
 * Design a data structure that supports the following two operations:
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * For example:
 * add(1)
 * add(2)
 * findMedian() -> 1.5
 * add(3) 
 * findMedian() -> 2
 *
 **********************************************************************/

public class MedianFinder {
    Queue<Long> small = new PriorityQueue<>(Collections.reverseOrder());   // small part of all elements
    Queue<Long> large = new PriorityQueue<>();          // large part of all elements, store 1 more value if odd
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        large.offer((long)num);
        small.offer(large.poll());
        if (small.size() > large.size()) {
            large.offer(small.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return large.size() > small.size() ?
                large.peek() : (large.peek()+small.peek()) / 2.0;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();