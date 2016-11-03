// Sourse : https://leetcode.com/problems/n-queens-ii/
// Date   : 2016-11-02

/***********************************************************************
 *
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 *
 **********************************************************************/

// based on previous solution 11ms
public class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        dfs(board, 0);
        return count;
    }
    private void dfs(char[][] board, int col) {
        if(col == board.length) {
            count++;
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (validate(board, i, col)) {
                board[i][col] = 'Q';
                dfs(board, col+1);
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
}

// boolean[][] generally faster than int[][]
// 3ms

public class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];     // columns   |
        boolean[] d1 = new boolean[2 * n];   // diagonals \
        boolean[] d2 = new boolean[2 * n];   // diagonals /
        backtracking(0, cols, d1, d2, n);
        return count;
    }
    
    public void backtracking(int row, boolean[] cols, boolean[] d1, boolean []d2, int n) {
        if(row == n) count++;

        for(int col = 0; col < n; col++) {
            int id1 = col - row + n;
            int id2 = col + row;
            if(cols[col] || d1[id1] || d2[id2]) continue;
            
            cols[col] = true; d1[id1] = true; d2[id2] = true;
            backtracking(row + 1, cols, d1, d2, n);
            cols[col] = false; d1[id1] = false; d2[id2] = false;
        }
    }
}