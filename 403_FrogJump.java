// Sourse : https://leetcode.com/problems/frog-jump/
// Date   : 2017-01-13

/***********************************************************************
 *
 * A frog is crossing a river. The river is divided into x units and at 
 * each unit there may or may not exist a stone. The frog can jump on a 
 * stone, but it must not jump into the water.
 * 
 * Given a list of stones' positions (in units) in sorted ascending order, 
 * determine if the frog is able to cross the river by landing on the last 
 * stone. Initially, the frog is on the first stone and assume the first 
 * jump must be 1 unit.
 * 
 * If the frog's last jump was k units, then its next jump must be either 
 * k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.
 * 
 * Note:
 * 
 * The number of stones is ≥ 2 and is < 1,100.
 * Each stone's position will be a non-negative integer < 231.
 * The first stone's position is always 0.
 **********************************************************************/



public class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(0).add(1);
        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            for (int step : map.get(stone)) {
                int reach = step + stone;
                if (reach == stones[stones.length-1]) return true;
                HashSet<Integer> currSet = map.get(reach);
                if (currSet != null) {
                    currSet.add(step);
                    currSet.add(step+1);
                    if (step-1 > 0) {
                        currSet.add(step-1);
                    }
                }
            }
        }
        return false;
    }
}