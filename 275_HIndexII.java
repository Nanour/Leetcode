// Sourse : https://leetcode.com/problems/h-index-ii/
// Date   : 2016-11-02

/***********************************************************************
 *
 * Follow up for H-Index: What if the citations array is sorted in ascending order? 
 * Could you optimize your algorithm?
 *
 **********************************************************************/

// O(N)
public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int len = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if (len <= citations[i])
                return len;
            else
                len--;
        }
        return len; 
    }
}

// O(logN)  https://discuss.leetcode.com/topic/23399/standard-binary-search
// After iteration, it is guaranteed that right+1 is the one we need to find 
// (i.e. len-(right+1) papars have at least len-(righ+1) citations)
public class Solution {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length-1;
        int len = citations.length;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (citations[mid] == len-mid) {
                return citations[mid];
            } else if (citations[mid] > len-mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return len - (right+1);
    }
}