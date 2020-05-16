package leetcode.LC_269;

import java.util.Arrays;

public class Solution269Adj {
    private final int N = 26;

    public String alienOrder(String[] words) {
        // Construct a graph of ???
        boolean[][] adj = new boolean[N][N];
        int[] visited = new int[26];
        buildGraph(words, adj, visited);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            if (visited[i]==0)
                if (!dfs(adj, visited, sb, i))
                    return "";

        // topological sort
        return sb.reverse().toString();
    }

    public void buildGraph(String[] words, boolean[][] adj, int[] visited) {
        // -1 = not even existed
        Arrays.fill(visited, -1);

        for (int i = 0; i < words.length; i++) {
            for (Character ch : words[i].toCharArray())
                visited[ch - 'a'] = 0;

            if (i > 0) {
                String w1 = words[i - 1], w2 = words[i];
                if (!w1.equals(w2) && w1.startsWith(w2)) {
                    Arrays.fill(visited, 2);
                    return;
                }

                int len = Math.min(w1.length(), w2.length());
                int j = 0;
                while (j < len) {
                    char ch1 = w1.charAt(j), ch2 = w2.charAt(j);
                    if (ch1 != ch2) {
                        adj[ch1 - 'a'][ch2 - 'a'] = true;
                        break;
                    }
                    j++;
                }
            }
        }
    }

    public boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
        visited[i] = 1;
        for (int j = 0; j < N; j++) {
            if (adj[i][j]) {
                if (visited[j] == 1)
                    return false;

                if (visited[j] == 0) {
                    if(!dfs(adj, visited, sb, j))
                        return false;
                }
            }
        }
        visited[i] = 2;
        sb.append((char) (i+'a'));
        return true;
    }
}