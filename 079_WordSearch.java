// Sourse : https://leetcode.com/problems/word-search/
// Date   : 2016-10-05

/***********************************************************************
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are 
 * those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * For example,
 * Given board =
 * [
 *  ['A','B','C','E'],
 *  ['S','F','C','S'],
 *  ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 *
 **********************************************************************/

// board = {"ab", "cd"} word = "bacd" is true
// need to set visit flag to false after checking whether this sequence contains word 

// has visit flag
// **Notes: 
//   1. add null check saves time
//   2. use char[i] instead of string.charAt(i) far more quick

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        boolean[][] visit = new boolean[board.length][board[0].length];
        for(int i =0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (existWord(board, i, j, word, visit, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean existWord(char[][] board, int i, int j, String word, boolean[][] visit, int count) {
        if (word.length() == count) {
            return true;
        }
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || visit[i][j] == true) {
            return false;
        }
        if (word.charAt(count) != board[i][j]) {
            return false;
        }
        visit[i][j] = true;
        boolean res = existWord(board, i+1, j, word, visit, count+1)
            || existWord(board, i, j+1, word, visit, count+1)
            || existWord(board, i-1, j, word, visit, count+1)
            || existWord(board, i, j-1, word, visit, count+1);
        visit[i][j] = false;
        return res;
    }
}

// no extra space

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        char[] words = word.toCharArray();
        for(int i =0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (existWord(board, i, j, words, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean existWord(char[][] board, int i, int j, char[] words, int count) {
        if (words.length == count) {
            return true;
        }
        if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
            return false;
        }
        if (words[count] != board[i][j]) {
            return false;
        }
        board[i][j] ^= 256;
        boolean res = existWord(board, i+1, j, words, count+1)
            || existWord(board, i, j+1, words, count+1)
            || existWord(board, i-1, j, words, count+1)
            || existWord(board, i, j-1, words, count+1);
        board[i][j] ^= 256;
        return res;
    }
}