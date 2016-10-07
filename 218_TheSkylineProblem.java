// Sourse : https://leetcode.com/problems/the-skyline-problem/
// Date   : 2016-10-06

/***********************************************************************
 *
 * A city's skyline is the outer contour of the silhouette formed by all the buildings 
 * in that city when viewed from a distance. Now suppose you are given the locations and 
 * height of all the buildings as shown on a cityscape photo (Figure A), write a program 
 * to output the skyline formed by these buildings collectively (Figure B).
 *
 **********************************************************************/

// references : https://briangordon.github.io/2014/08/the-skyline-problem.html

/*********************************************************************** 
 * sort building: 
 *       [[1,2,1],[1,2,2],[1,2,3]]
 *          
 *          |-----|
 *          |-----|
 *          |-----|
 *       ---|-----|---- 
 *       the skyline sort results should be: 
 *       For start point: [1,3], [1,2], [1,1] descend
 *       For end point: [2,1], [2,2], [2,3] ascend
 ***********************************************************************/

public class Solution {

    public static class sequenceComparator implements Comparator<int[]> {
        public int compare(int[] b1, int[] b2) {
            if (b1[0] != b2[0]) {
                return b1[0] - b2[0];
            }
            return b1[1] - b2[1];
        }
    }
    
    public static class heapComparator implements Comparator<Integer> {
        public int compare(Integer element1, Integer element2) {
            return element2 - element1;
        }
    }
    
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, new sequenceComparator());
        Queue<Integer> heap = new PriorityQueue<>(new heapComparator());
        heap.offer(0);
        int prev = 0;
        for(int[] h : height) {
            if(h[1] < 0) {
                heap.offer(-h[1]);
            } else {
                heap.remove(h[1]);
            }
            int cur = heap.peek();
            if(prev != cur) {
                res.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return res;
    }
}

/* different way to write Comparator

	// reference: https://discuss.leetcode.com/topic/22482/short-java-solution

 	Collections.sort(height, (a, b) -> {
            if(a[0] != b[0]) 
                return a[0] - b[0];
            return a[1] - b[1];
    });
    Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
    
*/