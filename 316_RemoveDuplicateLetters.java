// Sourse : https://leetcode.com/problems/remove-duplicate-letters/
// Date   : 2016-11-07

/***********************************************************************
 *
 * Given a string which contains only lowercase letters, remove duplicate 
 * letters so that every letter appear once and only once. You must make 
 * sure your result is the smallest in lexicographical order among all possible results.
 *
 ***********************************************************************/

// 返回最小的lexicographical order, 不能改变每个字母的顺序
// map记录每个char出现的次数， visited记录有没有访问过
// 如果当前没有被访问过，比较当前char是否比结果中最后一个char的值小，如果小并且map中这个char的值大于零，代表后面还会出现，则移出这个char
// 加入当前char

public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] map = new int[128], visited = new int[128];
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        for (char c : s.toCharArray()) {
            map[c]++;
        }
        for (char c : s.toCharArray()) {
            map[c]--;
            if (visited[c] == 0) {
                while (sb.charAt(sb.length()-1) > c && map[sb.charAt(sb.length()-1)] > 0) {
                    visited[sb.charAt(sb.length()-1)] = 0;
                    sb.deleteCharAt(sb.length()-1);
                }
                visited[c] = 1;
                sb.append(c);
            }
        }
        return sb.substring(1);
    }
}