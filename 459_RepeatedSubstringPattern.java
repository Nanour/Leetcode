// Sourse : https://leetcode.com/problems/repeated-substring-pattern/
// Date   : 2016-11-24

/***********************************************************************
 *
 * Given a non-empty string check if it can be constructed by taking a 
 * substring of it and appending multiple copies of the substring together. 
 * You may assume the given string consists of lowercase English letters 
 * only and its length will not exceed 10000.
 *
 **********************************************************************/


public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        int len = str.length();
    	for(int i = len/2 ; i >= 1 ; i--) {
    		if(len % i == 0) {
    			int num = len / i;
    			String subS = str.substring(0,i);
    			int j;
    			for(j = 1; j < num; j++) {
    				if(!subS.equals(str.substring(j*i,i+j*i))) break;
    			}
    			if(j == num)
    			    return true;
    		}
    	}
    	return false;
    }
}