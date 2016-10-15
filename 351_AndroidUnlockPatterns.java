// Sourse : https://leetcode.com/problems/android-unlock-patterns/
// Date   : 2016-10-14

/***********************************************************************
 *
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, 
 * count the total number of unlock patterns of the Android lock screen, which consist 
 * of minimum of m keys and maximum n keys.
 *
 * 1->8, 2->9 ... are valid
 *
 **********************************************************************/

// create a skip map

public class Solution {
    public int numberOfPatterns(int m, int n) {
        int skip[][] = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5; 
        boolean used[] = new boolean[10];
        int res = 0;
        for (int i = m; i <= n; i++) {
            res += dfs(used, skip, 1, i - 1) * 4;    // 1, 3, 7, 9 are symmetric
            res += dfs(used, skip, 2, i - 1) * 4;    // 2, 4, 6, 8 are symmetric
            res += dfs(used, skip, 5, i - 1);        // 5
        }
        return res;
    }
    private int dfs(boolean[] used, int[][] skip, int start, int remain) {
        if(remain < 0) return 0;
        if(remain == 0) return 1; 
        used[start] = true;
        int res = 0;
        for (int i = 1; i <= 9; i++) {
            if (!used[i] && (skip[start][i] == 0 || used[skip[start][i]] == true)) {
                res += dfs(used, skip, i, remain-1);
            }
        }
        used[start] = false;
        return res;
    }
}

// if 1->8, 2->9 ... are not valid

public class Solution {
    int count = 0;
    public int numberOfPatterns(int m, int n) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                dfs(m, n, new boolean[3][3], i, j, 1, "");
            }
        }
        return count;
    }
    private void dfs(int m, int n, boolean[][] used, int i, int j, int len, String res) {
        System.out.println(res+" "+count);
        if (len >= m) {
            count++;
            if (len == n) {
                return ;
            }
        }
        
        if (len < n) {
            int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};      // 只能遍历相邻的元素
            int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};
            for (int k = 0; k < 8; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if (x >= 0 && x < 3 && y >= 0 && y < 3 && used[x][y] == false) {
                    res += String.valueOf(x*3+y+1);
                    used[x][y] = true;
                    dfs(m, n, used, x, y, len+1, res);
                    used[x][y] = false;
                    res = res.substring(0, res.length()-1);
                }
            }   
        }
    }
}