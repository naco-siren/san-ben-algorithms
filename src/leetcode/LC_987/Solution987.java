package leetcode.LC_987;

import base.TreeNode;

import java.util.*;

/**
 * 987. Vertical Order Traversal of a Binary Tree
 */
class Solution987 {
    /**
     *
     * Time complexity: dfs: O(N) + sort: O(N log N) = O(N log N)
     * Space complexity: map: O(N) + stack: avg O(logN), worst O(N) = O(N)
     *
     */
    List<List<Integer>> verticalTraversal(TreeNode root) {
        // Map column index -> states as a bucket sort
        Map<Integer, List<State>> results = new HashMap<>();
        // Locate bucket boundaries
        int minCol = 0, maxCol = 0;

        // Perform DFS
        Stack<State> dfs = new Stack<>();
        if (root != null)
            dfs.push(new State(root, 0, 0));
        while (!dfs.isEmpty()) {
            final State state = dfs.pop();

            results.computeIfAbsent(state.col, x -> new ArrayList<>()).add(state);

            minCol = Math.min(minCol, state.col);
            maxCol = Math.max(maxCol, state.col);

            // NOTE: push right first due to DFS with stack
            if (state.node.right != null)
                dfs.push(new State(state.node.right, state.row + 1, state.col + 1));
            if (state.node.left != null)
                dfs.push(new State(state.node.left, state.row + 1, state.col - 1));
        }

        // Format for output
        List<List<Integer>> outputs = new ArrayList<>();
        for (int i = minCol; i <= maxCol; i++) {
            // Sort each index's states according to `row` and then `val`
            List<State> result = results.get(i);
            result.sort((s1, s2) -> {
                if (s1.row != s2.row) {
                    return s1.row - s2.row;
                } else {
                    return s1.node.val - s2.node.val;
                }
            });

            // Add to output list
            List<Integer> output = new ArrayList<>();
            for (State state : result)
                output.add(state.node.val);
            outputs.add(output);
        }
        return outputs;
    }

    static class State {
        public final TreeNode node;
        public final int row;
        public final int col;

        public State(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
}
