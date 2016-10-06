// Sourse : hhttps://leetcode.com/problems/add-and-search-word-data-structure-design/
// Date   : 2016-10-05

/***********************************************************************
 *
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. 
 * A . means it can represent any one letter.
 * For example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 *
 **********************************************************************/

public class WordDictionary {
    
    class TrieNode {
        private TrieNode[] next = new TrieNode[26];
        public boolean hasWord;
    } 
    
    TrieNode root = new TrieNode();
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.next[idx] == null) {
                curr.next[idx] = new TrieNode();
            }
            curr = curr.next[idx];
        }
        curr.hasWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return find(word, 0, root); 
    }
    
    public boolean find(String word, int idx, TrieNode curr) {
        if (curr == null) {
            return false;
        }
        if (idx == word.length()) {
            return curr.hasWord;
        }
        char c = word.charAt(idx);
        if (c == '.') {
            for (TrieNode node : curr.next) {
                if (find(word, idx+1, node)) {
                    return true;
                }
            }
            return false;
        }
        return find(word, idx+1, curr.next[c - 'a']);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");