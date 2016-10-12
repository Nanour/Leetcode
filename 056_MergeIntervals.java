// Sourse : https://leetcode.com/problems/merge-intervals/
// Date   : 2016-10-11

/***********************************************************************
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * 
 **********************************************************************/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */


// compare curr.start > end

public class Solution {
    public class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return i1.start-i2.start;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return new ArrayList<Interval>();
        }
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

// define Point class

public class Solution {
    public class PointComparator implements Comparator<Point> {
        public int compare(Point p1, Point p2) {
            if (p1.value == p2.value) {
                return p2.isStart-p1.isStart;
            } 
            return p1.value-p2.value;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Point> points = new ArrayList<Point>();
        for (Interval interval : intervals) {
            points.add(new Point(1, interval.start));
            points.add(new Point(0, interval.end));
        }
        Collections.sort(points, new PointComparator());
        int count = 0;
        Interval tempInterval = new Interval();
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0; i < points.size(); i++) {
            Point curr = points.get(i);
            if (curr.isStart == 1) {
                if (count++ == 0) {
                    tempInterval.start = curr.value;
                } 
            } else {
                if (--count == 0) {
                    tempInterval.end = curr.value;
                }
            }
            if (count == 0) {
                res.add(tempInterval);
                tempInterval = new Interval();
            }
        }
        return res;
    }
    
    class Point {
        int isStart;
        int value;
        Point(int isStart, int value) {
            this.isStart = isStart;
            this.value = value;
        }
    }
}