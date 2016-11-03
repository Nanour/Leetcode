// Sourse : https://leetcode.com/problems/max-sum-of-sub-matrix-no-larger-than-k/
// Date   : 2016-11-02

/***********************************************************************
 *
 * Given an array of citations (each citation is a non-negative integer) of a researcher, 
 * write a function to compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her 
 * N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in 
 * total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 
 * papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.
 * 
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 *
 **********************************************************************/

// https://discuss.leetcode.com/topic/48875/accepted-c-codes-with-explanation-and-references/5

public class Solution {
	public int maxSumSubmatrix(int[][] matrix, int k) {
	    //2D Kadane's algorithm + 1D maxSum problem with sum limit k
	    //2D subarray sum solution
	    
	    //boundary check
	    if(matrix.length == 0) return 0;
	    
	    int m = matrix.length, n = matrix[0].length;
	    int result = Integer.MIN_VALUE;
	    
	    //outer loop should use smaller axis
	    //now we assume we have more rows than cols, therefore outer loop will be based on cols 
	    for(int left = 0; left < n; left++){
	        //array that accumulate sums for each row from left to right 
	        int[] sums = new int[m];
	        for(int right = left; right < n; right++){
	            //update sums[] to include values in curr right col
	            for(int i = 0; i < m; i++){
	                sums[i] += matrix[i][right];
	            }
	            
	            //we use TreeSet to help us find the rectangle with maxSum <= k with O(logN) time
	            TreeSet<Integer> set = new TreeSet<Integer>();
	            //add 0 to cover the single row case
	            set.add(0);
	            int currSum = 0;
	            
	            for(int sum : sums){
	                currSum += sum;
	                //we use sum subtraction (curSum - sum) to get the subarray with sum <= k
	                //therefore we need to look for the smallest sum >= currSum - k
	                Integer num = set.ceiling(currSum - k);
	                if(num != null) result = Math.max( result, currSum - num );
	                set.add(currSum);
	            }
	        }
	    }
	    
	    return result;
	}
}