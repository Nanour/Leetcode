// Sourse : https://leetcode.com/problems/roman-to-integer/
// Date   : 2016-12-29

/***********************************************************************
 *
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 ***********************************************************************/

public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<Character, Integer>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    
        int sum = 0;
        for(int i = 0; i < s.length()-1; i++){
            int curr = romanMap.get(s.charAt(i));
            int next = romanMap.get(s.charAt(i+1));
            if(next > curr){
                sum -= curr;
            } else { 
                sum += curr;
            }
        }
        return sum += romanMap.get(s.charAt(s.length()-1));
    }
}