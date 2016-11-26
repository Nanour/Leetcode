// Sourse : https://leetcode.com/problems/alien-dictionary/
// Date   : 2016-11-25

/***********************************************************************
 *
 * Given a string array words, find the maximum value of length(word[i]) * 
 * length(word[j]) where the two words do not share common letters. You may 
 * assume that each word will contain only lower case letters. If no such two words exist, return 0.
 * 
 * Example 1:
 * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 * Return 16
 * The two words can be "abcw", "xtfn".
 * 
 * Example 2:
 * Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 * Return 4
 * The two words can be "ab", "cd".
 * 
 * Example 3:
 * Given ["a", "aa", "aaa", "aaaa"]
 * Return 0
 * No such pair of words.
 *
 **********************************************************************/


// won't pass test case 
/*  Input:["wrtkj","wrt"]
	Output:  "wtrkj"
	Expected: "" 
*/




public class Solution {
    public static final int N = 26;
    /**
     * visited[i] = -1. Not even exist.
     * visited[i] = 0. Exist. Non-visited.
     * visited[i] = 1. Visiting.
     * visited[i] = 2. Visited.
     */
    public String alienOrder(String[] words) {
        boolean[][] adj = new boolean[N][N];
        int[] visited = new int[N];
        boolean singleWord = true;
        buildGraph(words, visited, adj);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                if (!dfs(words, visited, adj, sb, i)) return "";
            }
        }
        return sb.reverse().toString();
    }
    
    private boolean dfs(String[] words, int[] visited, boolean[][] adj, StringBuilder sb, int curIndex) {
        visited[curIndex] = 1;
        for (int i = 0; i < N; i++) {
            if (adj[curIndex][i]) {
                if (visited[i] == 1) {
                    return false;      // cycle 
                } else if (visited[i] == 0) {
                    if (!dfs(words, visited, adj, sb, i)) {
                        return false;
                    }
                }
            }
        }
        visited[curIndex] = 2;
        sb.append((char)(curIndex+'a'));
        return true;
    }
    
    private void buildGraph(String[] words, int[] visited, boolean[][] adj) {
        Arrays.fill(visited, -1);
        for (int i = 0; i < words.length; i++) {
            for(char c : words[i].toCharArray()) visited[c - 'a'] = 0;
            if (i > 0) {
                String w1 = words[i - 1], w2 = words[i];
                int len = Math.min(w1.length(), w2.length());
                for (int j = 0; j < len; j++) {
                    char c1 = w1.charAt(j), c2 = w2.charAt(j);
                    if(c1 != c2) {
                        adj[c1 - 'a'][c2 - 'a'] = true;
                        break;       // find first difference char
                    }
                }
            }
        }
    }
}