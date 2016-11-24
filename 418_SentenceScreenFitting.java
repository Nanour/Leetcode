// Sourse : https://leetcode.com/problems/sentence-screen-fitting/
// Date   : 2016-11-23

/***********************************************************************
 *
 * Given a rows x cols screen and a sentence represented by a list of words, 
 * find how many times the given sentence can be fitted on the screen.
 * 
 * Note:
 * 
 * A word cannot be split into two lines.
 * The order of words in the sentence must remain unchanged.
 * Two consecutive words in a line must be separated by a single space.
 * Total words in the sentence won't exceed 100.
 * Length of each word won't exceed 10.
 * 1 ≤ rows, cols ≤ 20,000.
 * Example 1:
 * 
 * Input:
 * rows = 2, cols = 8, sentence = ["hello", "world"]
 * 
 * Output: 
 * 1
 * 
 * Explanation:
 * hello---
 * world---
 *
 ***********************************************************************/


// Optimized 
// 计算以curr word为起点这一行能不能放完剩下的word，若能，time++， 记在time[] 里面
// 同时计算以curr word为起点这一行放完下一行的起始word是什么， 记在nextIndex[] 里面
// Time complexity : O(n*(cols/lenAverage)) + O(rows), n 为单词个数

public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int[] nextIndex = new int[sentence.length];
        int[] times = new int[sentence.length];
        for (int i = 0; i < sentence.length; i++) {
            int curLen = 0;
            int curr = i;
            int time = 0;
            while (curLen + sentence[curr].length() <= cols) {
                curLen += sentence[curr++].length()+1;
                if(curr==sentence.length) {
                    curr = 0;
                    time++;
                }
            }
            nextIndex[i] = curr;
            times[i] = time;
        }
        int res = 0;
        int cur = 0;
        for(int i=0; i<rows; i++) {
            res += times[cur];
            cur = nextIndex[cur];
        }
        return res;
    }
}


// Brute Force O(rowr * cols) TLE
public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int currWord = 0, times = 0, r = 0, c = 0;
        while (r < rows) {
            if (c >= cols) {
                c = 0;
            }
            while (c < cols) {
                String word = sentence[currWord];
                if (word.length() <= (cols-c)) {
                    currWord++;
                    c += (word.length()+1);
                } else {
                    c = 0;
                    break;
                }
                if (currWord >= sentence.length) {
                    currWord = 0;
                    times++;
                }
            }
            r++;
        }
        return times;
    }
}