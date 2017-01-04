// Sourse : https://leetcode.com/problems/random-pick-index/
// Date   : 2016-12-29

/***********************************************************************
 *
 * Given an array of integers with possible duplicates, randomly output the 
 * index of a given target number. You can assume that the given target number must exist in the array.
 * 
 * Note:
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 * 
 ***********************************************************************/




// ** input may be extremely large, so we shouldn't store all data 

// O(1) space, O(n) time pick

public class Solution {
    int[] num;
    Random rand;
    public Solution(int[] nums) {
        num = nums;
        rand = new Random();
    }
    
    public int pick(int target) {
        int range = 0;
        int res = -1;
        for (int i = 0; i < num.length; i++) {
            if (num[i] == target) {
                res = rand.nextInt(++range) == 0 ? i : res;
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */



// O(n) space, O(1) time pick, O(n) time init
public class Solution {
    Map<Integer, List<Integer>> map;
    Random rand;
    public Solution(int[] nums) {
        map = new HashMap<Integer, List<Integer>>();
        rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<Integer>());
            }
            map.get(nums[i]).add(i);
        }
    }
    public int pick(int target) {
        int range = map.get(target).size();
        return map.get(target).get(rand.nextInt(range));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */