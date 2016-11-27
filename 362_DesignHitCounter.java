// Sourse : https://leetcode.com/problems/design-hit-counter/
// Date   : 2016-11-26

/***********************************************************************
 *
 * Design a hit counter which counts the number of hits received in the 
 * past 5 minutes.
 * 
 * Each function accepts a timestamp parameter (in seconds granularity) and 
 * you may assume that calls are being made to the system in chronological 
 * order (ie, the timestamp is monotonically increasing). You may assume that 
 * the earliest timestamp starts at 1.
 * 
 * It is possible that several hits arrive roughly at the same time.
 *
 **********************************************************************/

// 相同时间戳就push多个，最后返回size

public class HitCounter {
    Queue<Integer> q = null;
    /** Initialize your data structure here. */
    public HitCounter() {
        q = new LinkedList<Integer>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        q.offer(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!q.isEmpty() && timestamp - q.peek() >= 300) {
            q.poll();
        }
        return q.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */