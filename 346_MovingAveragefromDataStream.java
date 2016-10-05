// Sourse : hhttps://leetcode.com/problems/moving-average-from-data-stream/
// Date   : 2016-10-04

/***********************************************************************
 *
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 *
 **********************************************************************/

public class MovingAverage {
    Queue<Integer> queue;
    private int size;
    private double sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
         queue = new LinkedList<Integer>();
         this.size = size;
         this.sum = 0;
    }
    
    public double next(int val) {
        if (queue.size() >= size) 
            sum -= queue.poll();
        queue.add(val);
        sum += val;
        return sum/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */