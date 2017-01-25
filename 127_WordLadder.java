// Sourse : https://leetcode.com/problems/word-ladder/
// Date   : 2017-01-13

/***********************************************************************
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, 
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * For example,
 * 
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 **********************************************************************/

// 一端BFS

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(endWord);
        Queue<String> queue = new LinkedList<>();
        addNextWord(beginWord, wordList, queue);         // 因为已经加入了第二层的，所以dist初始为2
        int dist = 2;            
        while (!queue.isEmpty()) {                       // 如果第二层queue为empty，说明不存在这样的len，直接return 0
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) return dist;
                addNextWord(curr, wordList, queue);
            }
            dist++;
        }
        return 0;
    }
    private void addNextWord(String beginWord, Set<String> wordList, Queue<String> queue) {
        char[] currWord = beginWord.toCharArray();
        for (int i = 0; i < beginWord.length(); i++) {
            char originLetter = currWord[i];
            for (char c = 'a'; c <= 'z'; c++) {
                currWord[i] = c;
                String target = String.valueOf(currWord);
                if (wordList.contains(target)) {
                    wordList.remove(target);
                    queue.offer(target);
                }
            }
            currWord[i] = originLetter;
        }
    }
}

// 写法二：
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(endWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int dist = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) return dist;
                char[] currWord = curr.toCharArray();
                
                for (int j = 0; j < curr.length(); j++) {
                    char originLetter = currWord[j];
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        currWord[j] = c;
                        String target = String.valueOf(currWord);
                        if (wordList.contains(target)) {
                            wordList.remove(target);
                            queue.offer(target);
                        }
                    }
                    
                    currWord[j] = originLetter;
                }
            }
            dist++;
        }
        return 0;
    }
}


// 两端BFS
public class Solution { 
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();
    
        int len = 1;
        int strLen = beginWord.length();
        
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
    
            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    char origin = chs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chs[i] = c;
                        String target = String.valueOf(chs);
    
                        if (endSet.contains(target)) {
                            return len + 1;
                        }
    
                        if (wordList.contains(target)) {
                            temp.add(target);
                            wordList.remove(target);
                        }
                    }
                    chs[i] = origin;
                }
            }
            beginSet = temp;              // 注意每次temp都是下一层的words
            len++;
        }
        
        return 0;
    }
}