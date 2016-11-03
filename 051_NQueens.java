// Sourse : https://leetcode.com/problems/n-queens/
// Date   : 2016-11-02

/***********************************************************************
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard 
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens' placement, 
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 **********************************************************************/

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(board, 0, res);
        return res;
    }
    private void dfs(char[][] board, int col, List<List<String>> res) {
        if(col == board.length) {
            res.add(construct(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (validate(board, i, col)) {
                board[i][col] = 'Q';
                dfs(board, col+1, res);
                board[i][col] = '.';
            }
        }
    }
    private boolean validate(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < y; j++) {  // not same col
                if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i)) // not 45, not 135, not same row
                    return false;
            }
        }
        return true;
    }
    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}