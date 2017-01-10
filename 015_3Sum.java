// Sourse : https://leetcode.com/problems/3sum/
// Date   : 2016-11-28

/***********************************************************************
 *
 * Given an array S of n integers, are there elements a, b, c in S such 
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 *  [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 **********************************************************************/

// 30ms beats 56%

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>(); 
        for (int i = 0; i < num.length-2; i++) {
            if (num[i] > 0) return res;                                    // 因为已经排序，所以当最小的数大于0，可以退出
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {                 // 循环避免重复, 注意先加上判断条件
                int low = i+1, high = num.length-1, sum = 0 - num[i];
                while (low < high) {
                    if (num[low] + num[high] == sum) {
                        res.add(Arrays.asList(num[i], num[low], num[high]));             // Arrays.asList()的用法
                        while (low < high && num[low] == num[low+1]) low++;              // 循环避免重复， 注意先加上判断条件 low < high
                        while (low < high && num[high] == num[high-1]) high--;
                        low++; 
                        high--;                                                    // 找到一组后继续找，不是break;
                    } else if (num[low] + num[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
               }
            }
        }
        return res;
    }
}