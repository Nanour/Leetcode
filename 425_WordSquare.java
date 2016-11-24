// Sourse : https://leetcode.com/problems/word-squares/
// Date   : 2016-11-23

/***********************************************************************
 *
 * Given a set of words (without duplicates), find all word squares you can 
 * build from them.
 * 
 * A sequence of words forms a valid word square if the kth row and column 
 * read the exact same string, where 0 ≤ k < max(numRows, numColumns).
 * 
 * For example, the word sequence ["ball","area","lead","lady"] forms a word 
 * square because each word reads the same both horizontally and vertically.
 * 
 * b a l l
 * a r e a
 * l e a d
 * l a d y
 * Note:
 *  There are at least 1 and at most 1000 words.
 * All words will have the exact same length.
 * Word length is at least 1 and at most 5.
 * Each word contains only lowercase English alphabet a-z.
 *
 ***********************************************************************/

// 直接暴力枚举会超时
// 先根据各个word建Trie，每个trie node中还包括以这个前缀开始的单词
// 当前一个单词固定好后，后面单词的前缀也已经固定，先枚举各个单词，再枚举以某个前缀开始的单词
// 当单词个数==单词长度停止
// 每个单词可以重复
// https://discuss.leetcode.com/topic/63516/explained-my-java-solution-using-trie-126ms-16-16


public class Solution {
    class TrieNode {
        List<String> startWith;
        TrieNode[] children;
        TrieNode() {
            startWith = new ArrayList<String>();
            children = new TrieNode[26];
        }
    }
    class Trie {
        TrieNode root;
        
        Trie(String[] words) {
            root = new TrieNode();
            for (String word : words) {
                TrieNode curr = root;
                for (char ch : word.toCharArray()) {
                    int idx = ch - 'a';
                    if (curr.children[idx] == null) curr.children[idx] = new TrieNode();
                    curr.children[idx].startWith.add(word);
                    curr = curr.children[idx];
                }
            }
        }
        List<String> searchByPrefix(String prefix) {
            TrieNode curr = root;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (curr.children[idx] == null) {
                    return new ArrayList<String>();
                }
                curr = curr.children[idx];
            }
            return curr.startWith;
        }
    }
    
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0)
            return res;
        Trie trie = new Trie(words);
        int len = words[0].length();
        List<String> resTemp = new ArrayList<>();
        for (String word : words) {
            resTemp.add(word);
            search(resTemp, res, len, trie);
            resTemp.remove(resTemp.size()-1);
        }
        return res;
    }
    public void search(List<String> temp, List<List<String>> res, int len, Trie trie) {
        if (temp.size() == len) {
            res.add(new ArrayList<>(temp));
            return ;
        }
        int idx = temp.size();
        StringBuilder prefixBuilder = new StringBuilder();
        for (String s : temp)
            prefixBuilder.append(s.charAt(idx));
        List<String> startWith = trie.searchByPrefix(prefixBuilder.toString());
        for (String sw : startWith) {
            temp.add(sw);
            search(temp, res, len, trie);
            temp.remove(temp.size()-1);
        }
    }
}

// 也可以用hashmap保存前缀
// https://discuss.leetcode.com/topic/65116/my-java-solution-using-hashmap-and-backtracking-163ms

public class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ret = new ArrayList<List<String>>();
        if(words.length==0 || words[0].length()==0) return ret;
        Map<String, Set<String>> map = new HashMap<>();
        int squareLen = words[0].length();
        // create all prefix
        for(int i=0;i<words.length;i++){
            for(int j=-1;j<words[0].length();j++){
                if(!map.containsKey(words[i].substring(0, j+1))) map.put(words[i].substring(0, j+1), new HashSet<String>());
                map.get(words[i].substring(0, j+1)).add(words[i]);
            }
        }
        helper(ret, new ArrayList<String>(), 0, squareLen, map);
        return ret;
    }
    public void helper(List<List<String>> ret, List<String> cur, int matched, int total, Map<String, Set<String>> map){
        if(matched == total) {ret.add(new ArrayList<String>(cur));return;}
        // build search string
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=matched-1;i++) sb.append(cur.get(i).charAt(matched));
        // bachtracking
        Set<String> cand = map.get(sb.toString());
        if(cand==null) return;
        for(String str:cand){
            cur.add(str);
            helper(ret, cur, matched+1, total, map);
            cur.remove(cur.size()-1);
        }
    }
}
