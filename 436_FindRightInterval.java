// Sourse : https://leetcode.com/problems/find-right-interval/
// Date   : 2016-11-02

/***********************************************************************
 *
 * Given a set of intervals, for each of the interval i, check if there exists an 
 * interval j whose start point is bigger than or equal to the end point of the 
 * interval i, which can be called that j is on the "right" of i.
 * 
 * For any interval i, you need to store the minimum interval j's index, which means 
 * that the interval j has the minimum start point to build the "right" relationship 
 * for interval i. If the interval j doesn't exist, store -1 for the interval i. 
 * Finally, you need output the stored value of each interval as an array.
 * 
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * You may assume none of these intervals have the same start point.
 ***********************************************************************/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

// make a clone Interval array, and then sort according to start.

public class Solution {
   public int[] findRightInterval(Interval[] intervals) {
        Interval[] list = new Interval[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            list[i] = new Interval(intervals[i].start, i);
        }
        Arrays.sort(list, new customComp());
        int[] result = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            Interval key = new Interval(intervals[i].end, 0);    
            int index = Arrays.binarySearch(list, key, new customComp());
            if(index < 0) index = -index-1;
            if(index >= intervals.length) result[i] = -1;
            else result[i] = list[index].end;
        }
        return result;
    }
    
    private class customComp implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
}