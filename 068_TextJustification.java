// Sourse : https://leetcode.com/problems/text-justification/
// Date   : 2016-12-31

/***********************************************************************
 *
 * Given an array of words and a length L, format the text such that each 
 * line has exactly L characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many 
 * words as you can in each line. Pad extra spaces ' ' when necessary so 
 * that each line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. 
 * If the number of spaces on a line do not divide evenly between words, 
 * the empty slots on the left will be assigned more spaces than the slots 
 * on the right.
 * 
 * For the last line of text, it should be left justified and no extra space 
 * is inserted between words.
 * 
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * 
 * Return the formatted lines as:
 * [
 *   "This    is    an",
 *   "example  of text",
 *   "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 *
 **********************************************************************/


/* 神烦的细节题，木有任何算法。。
    * 首先要计算一行可以放下多少个word，只有当超过maxLen，即放不下的时候才将这一行结束并放入到res中（正好放下word的情况先不结束，当下一个word出现超过的maxLen时才放）
    * 知道一行有几个word以后要决定空格如果分配
        * 如果这一行只有一个word，或者这是最后一行，左对齐
        * 如果这一行有多个word，并且不是最后一行，中间对齐
        * 平均空格数计算：
            * k = (maxLen - curLen) / (word个数-1)
            * 前m组每组有空格数k+1：m = (maxLen - curLen) % (word个数-1)

        * 例子：
            * L = 21，curLen = 14，n = 4
                k = (21 - 14) / (4-1) = 2
                m = (21 - 14) % (4-1)  = 1
                A---B--C--D
`Note:`
1. 注意各种corner case：
    * 当读入到第i = words.size()-1 个word时为最后一行。最后一行永远左对齐，所以k = 1，m = 0；
    * 当一行只有一个word时，不需要计算空格数，归类到最后一行的logic里面，直接左对齐
    * 当word[i].size() == L时，正好满行，仍需计算，但是可以知道k = 1, m = 0;

*/ 

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int start = 0, end = -1, totalLen = 0;
        boolean isLast = false;
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < words.length) {
            if(words[i].length() > maxWidth) return res;
            int newLen = totalLen + (end-start+1) + words[i].length();
            if(newLen <= maxWidth) { // words[i] can be in current line
                end  = i;
                totalLen += words[i].length();
                i++;
            } else {  // word[i-1] is the end of a line
                String line = createLine(words, maxWidth, start, end, totalLen, false);
                res.add(line);
                start = i;
                end = i-1;
                totalLen = 0;
            }
        }
        String lastLine = createLine(words, maxWidth, start, end, totalLen, true);
        res.add(lastLine);
        return res;
    }
    private String createLine(String[] words, int maxWidth, int start, int end , int totalLen, boolean isLast) {
        StringBuilder line = new StringBuilder();
        if(start < 0 || end >= words.length || start > end) return line.toString();
        line.append(words[start]);
        int n = end - start + 1;
        
        // special case: one word or last line - left justified
        if(n == 1 || isLast) {
            for (int i = start + 1; i <= end; i++) 
                line.append(" ").append(words[i]);
            int j = maxWidth-totalLen-(n-1);
            for (int i = 0; i < j; i++) {
                line.append(" ");
            }
            return line.toString();
        }
        
        // normal case: fully justified
        int k = (maxWidth-totalLen)/(n-1), m = (maxWidth-totalLen)%(n-1);
        for(int i = start + 1; i <= end; i++) {
            int nspace = ((i-start) <= m) ? k+1 : k;
            for (int j = 0; j < nspace; j++) {
                line.append(" ");
            }
            line.append(words[i]);
        }
        return line.toString();
    }
}