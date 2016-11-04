// Sourse : https://leetcode.com/problems/missing-ranges/
// Date   : 2016-11-03

/***********************************************************************
 *
 * Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
 * 
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 *
 ***********************************************************************/

// 注意corner case！！！
// 转化成long避免corner case

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        long start = lower, end = lower;
        for (int n : nums) {
            end = (long)n - 1;
            addRange(res, start, end);
            start = (long)n + 1;
        }
        addRange(res, start, upper);
        return res;
    }
    private void addRange(List<String> res, long start, long end) {
        if (start <= end) {
            StringBuilder sb = new StringBuilder();
            sb.append(start);
            if (start < end) {
                sb.append("->").append(end);
            }
            res.add(sb.toString());
        }
    }
}