// Sourse : https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
// Date   : 2016-10-06

/***********************************************************************
 *
 * Two arrya, find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * Example 1:
 * Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
 * Return: [1,2],[1,4],[1,6]
 * The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 
 * Return min(k, nums1.length * nums2.length) parirs
 *
 **********************************************************************/

// https://discuss.leetcode.com/topic/52953/share-my-solution-which-beat-96-42

public class Solution {
    class Node {
        int sum, x, y;
        public Node(int sum, int x, int y) {
            this.sum = sum;
            this.x = x;
            this.y = y;
        }
    }
    public static class findkthSmallestComparator implements Comparator<Node> {
        public int compare(Node n1, Node n2) {
            return n1.sum-n2.sum;
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) 
            return new ArrayList<int[]>();
        Comparator<Node> comp = new findkthSmallestComparator();
        Queue<Node> heap = new PriorityQueue<Node>(k, comp);
        List<int[]> res = new ArrayList<int[]>();
        int m = nums1.length, n = nums2.length;
        for (int i = 0; i < nums1.length; i++) {
            heap.offer(new Node(nums1[i]+nums2[0], i, 0));                  // first put all nums1's value pait nums2[0]
        }
        for (int j = 0; j < (m*n) && j < k; j++) {
            Node curr = heap.poll();
            int x = curr.x;
            int y = curr.y;
            res.add(new int[]{nums1[x], nums2[y]});  
            if (y < n-1) {
                heap.offer(new Node(nums1[x]+nums2[y+1], x, y+1));          // if y+1 < nums2.length, move to next
            }
        }
        return res;
    }
}