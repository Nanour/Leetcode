// Sourse : https://leetcode.com/problems/largest-number/
// Date   : 2016-10-04

/***********************************************************************
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 **********************************************************************/

// String str1 = "9", str2 = "31";
// String s1 =  str1 + str2; // 931
// String s2 = str2 + str1; // 319
// compare which is larger 

public class Solution {
    
    public static class compareLarestNum implements Comparator<String> {
		    public int compare(String str1, String str2){
		        String s1 = str1 + str2;
			    String s2 = str2 + str1;
			    return s2.compareTo(s1); // return positive integer if s2 lexicographically follows the argument string s1
		    }
    }  
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
		for(int i = 0; i < nums.length; i++)
		    strs[i] = String.valueOf(nums[i]);
		    
        Comparator<String> comp = new compareLarestNum();
        Arrays.sort(strs, comp);
        
        //trim 0 
        if (strs[0].charAt(0) == '0') return "0"; 
        
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }
}