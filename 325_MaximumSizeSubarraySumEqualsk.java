// Sourse : https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
// Date   : 2016-11-29

/***********************************************************************
 *
 * Given an array nums and a target value k, find the maximum length of a 
 * subarray that sums to k. If there isn't one, return 0 instead.
 * 
 * Note:
 * The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
 * 
 * Example 1:
 * Given nums = [1, -1, 5, -2, 3], k = 3,
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 *
 * Example 2:
 * Given nums = [-2, -1, 2, 1], k = 1,
 * return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 * 
 * Follow Up:
 * Can you do it in O(n) time?
 **********************************************************************/



// O(n) hash table 31ms, beats 54%

public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i-1];                  // 不需要新开数组存储subsum值
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);                             // 加入第一个0，设其index 为-1
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i]-k))                   // 因为是subsum，所以是nums[i]-k, 得到的j为nums[i]-nums[j] = k，不要减反！！
                max = Math.max(max, i-map.get(nums[i]-k));
            if (!map.containsKey(nums[i]))                    // 只将最左边的subsum加入map中，因为是求最长，所以有duplicates的情况下加入最左
                map.put(nums[i], i);
        }
        return max;
    }
} 




// O(n^2) brute force TLE
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int[] sums  = new int[nums.length+1];
        sums[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i+1] = sums[i] + nums[i];                   // 从0开始计算subsum，每次加上前面的值
        }
        System.out.println(Arrays.toString(sums));
        int max = 0;
        for (int i = 0; i < sums.length; i++) {
            for (int j = 0; j < sums.length; j++) {
                if (sums[j] - sums[i] == k)
                    max = Math.max(max, j-i);                // j-i, 因为已经是subsum，不需要j-i+1
            }
        }
        return max;
    }
}