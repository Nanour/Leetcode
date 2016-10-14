// Sourse : https://leetcode.com/problems/count-numbers-with-unique-digits/
// Date   : 2016-10-13

/***********************************************************************
 *
 * Given a non-negative integer n, count all numbers with unique digits, 
 * x, where 0 ≤ x < 10n.
 * Example:
 * Given n = 2, return 91. (The answer should be the total numbers in the 
 * range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 *
 **********************************************************************/

// DP
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int res = 10, uniqueNumber = 9, availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueNumber *= availableNumber;
            availableNumber--;
            res += uniqueNumber;
        }
        return res;
    }
}


// too slow !!! backtracking 529ms
public class Solution {
    private int count = 0;
    public int countNumbersWithUniqueDigits(int n) {
        backtracking(new ArrayList<Integer>(), n, 0);
        return count;
    }
    private void backtracking(ArrayList<Integer> path, int n, int start) {
        if (path.size() > n || (path.size() > 0 && path.get(0) == 0)) {
            return ;
        }
        count++;
        for (int i = 0; i <= 9; i++) {
            if (path.contains(i)) {
                continue;
            }
            path.add(i);
            backtracking(path, n, i+1);
            path.remove(path.size()-1);
        }
    }
}