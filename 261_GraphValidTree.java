// Sourse : https://leetcode.com/problems/graph-valid-tree/
// Date   : 2016-12-31

/***********************************************************************
 *
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges 
 * (each edge is a pair of nodes), write a function to check whether these 
 * edges make up a valid tree.
 * 
 * For example:
 * 
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * 
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 *
 **********************************************************************/


// map

public class Solution {
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    public boolean validTree(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            hm.put(i, i);
        }
        for (int i = 0; i < edges.length; i++) {
            int father1 = find(edges[i][0]);
            int father2 = find(edges[i][1]);
            if (father1 == father2) return false;
            hm.put(father1, father2);
        }
        return edges.length == n - 1;
    }
    private int find(int node) {
        int father = hm.get(node);
        while (father != hm.get(father)) {
            father = hm.get(father);
        }
        return father;
    }
}

// array
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // initialize n isolated islands
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;
            
            // union
            nums[x] = y;
        }
        
        return edges.length == n - 1;
    }
    
    int find(int nums[], int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
}