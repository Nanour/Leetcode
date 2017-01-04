// Sourse : https://leetcode.com/problems/paint-house-ii/
// Date   : 2017-01-01

/***********************************************************************
 *
 * There are a row of n houses, each house can be painted with one of 
 * the k colors. The cost of painting each house with a certain color is 
 * different. You have to paint all the houses such that no two adjacent 
 * houses have the same color.
 * 
 * The cost of painting each house with a certain color is represented 
 * by a n x k cost matrix. For example, costs[0][0] is the cost of painting 
 * house 0 with color 0; costs[1][2] is the cost of painting house 1 with 
 * color 2, and so on... Find the minimum cost to paint all houses.
 * 
 * Note:
 * All costs are positive integers.
 * 
 * Follow up:
 * Could you solve it in O(nk) runtime?
 *
 **********************************************************************/

public class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length == 0) return 0;
        int minCost1 = 0, minCost2 = 0, index = -1;
        for (int i = 0; i < costs.length; i++) {
            int currMinCost1 = Integer.MAX_VALUE, currMinCost2 = Integer.MAX_VALUE;
            int currMinCostIndex = -1;
            for (int j = 0; j < costs[0].length; j++) {
                int cost = costs[i][j] + (j != index ? minCost1 : minCost2);
                if (cost < currMinCost1) {
                    currMinCost2 = currMinCost1;
                    currMinCost1 = cost;
                    currMinCostIndex = j;
                } else if (cost < currMinCost2) {
                    currMinCost2 = cost;
                }
            }
            minCost1 = currMinCost1;
            minCost2 = currMinCost2;
            index = currMinCostIndex;
        }
        return minCost1;
    }
}