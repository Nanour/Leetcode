// Sourse : https://leetcode.com/problems/russian-doll-envelopes/
// Date   : 2016-11-01

/***********************************************************************
 *
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). 
 * One envelope can fit into another if and only if both the width and height of one envelope 
 * is greater than the width and height of the other envelope.
 * 
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 *
 **********************************************************************/

// O(N^2) 606ms
public class Solution {
    public static class customCompare implements Comparator<int[]> {
        public int compare(int[] arr1, int[] arr2){
            if(arr1[0] == arr2[0])
                return arr1[1] - arr2[1];
            else
                return arr1[0] - arr2[0];
       } 
    }
    
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, new customCompare());
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < envelopes.length; i++) {
            int[] curr = envelopes[i];
            for (int j = i+1; j < envelopes.length; j++) {
                 if (envelopes[i][0] < envelopes[j][0]
                    && envelopes[i][1] < envelopes[j][1]){
                    dp[j] = Math.max(dp[j], 1 + dp[i]); 
                    max = Math.max(dp[j], max);
                }  
            }
        }
        return max;
    }
}

// O(NlogN) 21ms
// Sort the array. Ascend on width and descend on height if width are same.
// Find the longest increasing subsequence based on height.
// Since the width is increasing, we only need to consider height.
// [3, 4] cannot contains [3, 3], so we need to put [3, 4] before [3, 3] 
// when sorting otherwise it will be counted as an increasing number if the order is [3, 3], [3, 4]

public class Solution {
    public static class customCompare implements Comparator<int[]> {
        public int compare(int[] arr1, int[] arr2){
            if(arr1[0] == arr2[0])
                return arr2[1] - arr1[1];
            else
                return arr1[0] - arr2[0];
       } 
    }
    
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, new customCompare());
        int[] dp = new int[envelopes.length];
        int len = 0;
        for(int[] envelope : envelopes){
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if(index < 0)
                index = -(index + 1);
            dp[index] = envelope[1];
            if(index == len)
                len++;
        }
        return len;
    }
}