// Sourse : https://leetcode.com/problems/game-of-life/
// Date   : 2016-10-31

/***********************************************************************
 *
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, 
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using 
 * the following four rules (taken from the above Wikipedia article):
 * 
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 *
 * Write a function to compute the next state (after one update) of the board given its current state.
 *
 **********************************************************************/

public class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = numberOfLives(board, m, n, i, j);
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {  
                    board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;  // Get the 2nd state.
            }
        }
    }
    private int numberOfLives(int[][] board, int m, int n, int i, int j) {
        int[] x = {1,1,1,-1,-1,-1,0,0};
        int[] y = {-1,0,1,-1,0,1,-1,1};
        int lives = 0;
        for (int k = 0; k < 8; k++) {
            int xPos = i + x[k];
            int yPos = j + y[k];
            if (xPos >= 0 && xPos < m && yPos >= 0 && yPos < n) {
                lives += board[xPos][yPos] & 1;             // use board[i][j] & 1 instead of == 1 
                											// because after add the second bit, it won't be 1 anymore.
            }
        }
        return lives;
    }
}