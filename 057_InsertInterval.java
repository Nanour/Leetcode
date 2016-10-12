// Sourse : https://leetcode.com/problems/insert-interval/
// Date   : 2016-10-11

/***********************************************************************
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 **********************************************************************/


// sort first  24ms

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return i1.start-i2.start;
        }
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        Collections.sort(intervals, new IntervalComparator());
        List<Interval> res = new ArrayList<Interval>();
        int start = (intervals.get(0)).start, end = (intervals.get(0)).end;
        for (Interval curr : intervals) {
            if (curr.start > end) {
                res.add(new Interval(start, end));
                start = curr.start;
            }
            end = Math.max(curr.end, end);
        }
        res.add(new Interval(start, end));
        return res;
    }
}

// insert directly   17ms

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.size() == 0) {
            return Arrays.asList(newInterval);
        }
        int hasInsert = 0;
        List<Interval> res = new ArrayList<Interval>();
        for (Interval curr : intervals) {
            if (hasInsert == 1) res.add(curr);
            else {
                if (curr.start > newInterval.end) {            // finish merge
                    hasInsert = 1;
                    res.add(newInterval);
                    res.add(curr);  
                } else if (newInterval.start <= curr.end) {         // start merge
                    newInterval.start = Math.min(curr.start, newInterval.start);
                    newInterval.end = Math.max(curr.end, newInterval.end);
                } else {
                    res.add(curr);
                }   
            }
        }
        if (hasInsert == 0) {
            res.add(newInterval);
        }
        return res;
    }
}