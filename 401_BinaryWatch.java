// Sourse : https://leetcode.com/problems/binary-watch/
// Date   : 2016-10-13

/***********************************************************************
 *
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), 
 * and the 6 LEDs on the bottom represent the minutes (0-59).
 * Each LED represents a zero or one, with the least significant bit on the right.
 * 
 * Given a non-negative integer n which represents the number of LEDs that are currently 
 * on, return all possible times the watch could represent.
 * Example:
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *
 **********************************************************************/

public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<String>();
        int[] hour = new int[]{8,4,2,1}, mins = new int[]{32,16,8,4,2,1};
        for (int i = 0; i <= num; i++) {
            List<Integer> hourList = generateDigit(hour, i);
            List<Integer> minsList = generateDigit(mins, num-i);
            for (Integer currHour : hourList) {
                if (currHour >= 12) {
                    continue;
                }
                for (Integer currMins : minsList) {
                    if (currMins >= 60) {
                        continue;
                    }
                    res.add(currHour + ":" + (currMins >= 10 ? currMins : "0"+currMins));
                }
            }
        }
        return res;
    }
    private List<Integer> generateDigit(int[] nums, int count) {
        List<Integer> res = new ArrayList<Integer>();
        backtracking(nums, count, 0, 0, res);
        return res;
    }
    private void backtracking(int[] nums, int count, int sum, int start, List<Integer> res) {
        if (count == 0) {
            res.add(sum);
            return ;
        }
        for (int i = start; i < nums.length; i++) {
            backtracking(nums, count-1, sum+nums[i], i+1, res);
        }
    }
}