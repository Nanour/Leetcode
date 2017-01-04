// Sourse : https://leetcode.com/problems/meeting-rooms-ii/
// Date   : 2016-11-29

/***********************************************************************
 *
 * Given an array of meeting time intervals consisting of start and end 
 * times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * 
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 *
 **********************************************************************/

// beats 88.31%

public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for(int i=0; i<starts.length; i++) {
            if(starts[i]<ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }
}


// sort each point  beats 22.9%  O(NlogN)

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
    class Point{
        int time;
        int isStart;
        Point(int t, int flag) {
            time = t; 
            isStart = flag;
        }
    }
    
    public static class compareInterval implements Comparator<Point> {
        public int compare(Point p1, Point p2) {
            if (p1.time == p2.time) 
                return p1.isStart - p2.isStart;
            return p1.time - p2.time;
        }
    }
    
    public int minMeetingRooms(Interval[] intervals) {
        List<Point> list = new ArrayList<Point>();
        for (Interval interval : intervals) {
            list.add(new Point(interval.start, 1));
            list.add(new Point(interval.end, 0));
        }
        Comparator<Point> cmp = new compareInterval();
        Collections.sort(list, cmp);
        int roomCount = 0;
        int max = 0;
        for (Point p : list) {
            if (p.isStart == 1) {
                roomCount++;
            } else {
                roomCount--;
            }
            max = Math.max(max, roomCount);
        }
        return max;
    }
}


// use heap beats 33.95%

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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
            
        // Sort the intervals by start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.start - b.start; }
        });
        
        // Use a min heap to track the minimum end time of merged intervals
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.end - b.end; }
        });
        
        // start with the first meeting, put it to a meeting room
        heap.offer(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            // get the meeting room that finishes earliest
            Interval interval = heap.poll();
            
            if (intervals[i].start >= interval.end) {
                // if the current meeting starts right after 
                // there's no need for a new room, merge the interval
                interval.end = intervals[i].end;
            } else {
                // otherwise, this meeting needs a new room
                heap.offer(intervals[i]);
            }
            
            // don't forget to put the meeting room back
            heap.offer(interval);
        }
        
        return heap.size();
    }
}

