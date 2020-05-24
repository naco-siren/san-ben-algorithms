package leetcode.LC_785;

import java.util.Arrays;
import java.util.Stack;

/**
 * 785. Is Graph Bipartite?
 *
 * Note that the input representation is:
 *                  `graph[i]` is the neighbors of node `i`.
 *
 */
class Solution785 {
    /**
     *
     *
     * Approach #1: Red-black color by DFS
     *
     *
     * Time Complexity: O(N + E), N: the number of nodes in the graph, E: the number of edges.
     * Space Complexity: O(N), i.e. `colors` array.
     *
     */
    boolean isBipartite(int[][] graph) {
        final int N = graph.length;

        int[] colors = new int[N];
        Arrays.fill(colors, -1);

        for (int i = 0; i < N; i++) {
            if (colors[i] == -1) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                colors[i] = 0;

                while (!stack.isEmpty()) {
                    Integer node = stack.pop();
                    for (int nei : graph[node]) {
                        if (colors[nei] == -1) {
                            stack.push(nei);
                            colors[nei] = colors[node] ^ 1;
                        } else if (colors[nei] == colors[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
