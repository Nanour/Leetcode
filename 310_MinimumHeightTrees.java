// Sourse : https://leetcode.com/problems/minimum-height-trees/
// Date   : 2016-11-26

/***********************************************************************
 *
 * For a undirected graph with tree characteristics, we can choose any node 
 * as the root. The result graph is then a rooted tree. Among all possible 
 * rooted trees, those with minimum height are called minimum height trees (MHTs). 
 * Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 * 
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number 
 * n and a list of undirected edges (each edge is a pair of labels).
 * 
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] 
 * is the same as [1, 0] and thus will not appear together in edges.
 *
 **********************************************************************/


// 从leave往内一圈圈剪枝，最后剩下的就是最小height的root

// ！！注意！！ list.remove() 可以remove index或者Object，如果是int的数，需要remove.(Integer.valueOf(i))
// Collections.singletonList(0) singletonList(T o)
// Returns an immutable list containing only the specified object.
// new ArrayList<Integer>(0) return 的是0长度的空list

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<List<Integer>> adjs = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) adjs.add(new ArrayList<>());
        for (int[] edge : edges) {
            adjs.get(edge[0]).add(edge[1]);
            adjs.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adjs.get(i).size() == 1) leaves.add(i);
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leave : leaves) {
                int j = adjs.get(leave).get(0);
                adjs.get(j).remove(Integer.valueOf(leave));
                if (adjs.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
         }
         return leaves;
    }
}