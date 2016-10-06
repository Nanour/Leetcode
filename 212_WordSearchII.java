// Sourse : https://leetcode.com/problems/word-search-ii/
// Date   : 2016-10-05

/***********************************************************************
 *
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" 
 * cells are those horizontally or vertically neighboring. The same letter cell may not be 
 * used more than once in a word.
 * For example,
 * Given words = ["oath","pea","eat","rain"] and board =
 * [
 *  ['o','a','a','n'],
 *  ['e','t','a','e'],
 *  ['i','h','k','r'],
 *  ['i','f','l','v']
 * ]
 * Return ["eat","oath"].
 *
 **********************************************************************/


// Pure backtracking (dfs) will cause TLE
// Need Trie + dfs

/*
 * Trie:
 *            root  (nothing stored)       	
 *           / | \ \
 *          e  o  p r
 *         /   |   \ \
 *        a    a    e a
 *       /     |     \ \
 *     [t]     t     [a]i
 *             |         \
 *            [h]        [n]
 *
 */

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = builderTrie(words);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode curr, List<String> res) {
        if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
            return ;
        }
        char c = board[i][j];
        if (c == '#' || curr.next[c - 'a'] == null) {
            return ;
        }   
        curr = curr.next[c - 'a'];
        if (curr.word != null) {
            res.add(curr.word);
            curr.word = null; 
        }
        board[i][j] = '#';
        dfs(board, i+1, j, curr, res);
        dfs(board, i, j+1, curr, res);
        dfs(board, i-1, j, curr, res);
        dfs(board, i, j-1, curr, res);
        board[i][j] = c;
    }
    // root 不表示任何字符
    private TrieNode builderTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (curr.next[index] == null) {
                    curr.next[index] = new TrieNode();
                }
                curr = curr.next[index];
            }
            curr.word = word;
        }
        return root;
    }
    
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}