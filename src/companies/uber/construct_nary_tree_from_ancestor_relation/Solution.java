package companies.uber.construct_nary_tree_from_ancestor_relation;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] i1 = new int[][]{
                new int[]{1, 1}, new int[]{1, 2}, new int[]{1, 3}, new int[]{1, 4},
                new int[]{2, 2},
                new int[]{3, 3}, new int[]{3, 4},
                new int[]{4, 4}
        };
        Solution s1 = new Solution(i1);
        Node root = s1.solve();
        //     1
        //    / \
        //   2   3
        //        \
        //         4
    }

    private int[][] _relations;

    Solution(final int[][] relations) {
        this._relations = relations;
    }

    Node solve() {
        HashMap<Integer, Node> nodes = new HashMap<>();

        // Calculate each node's in-degree and out-degree
        for (int[] pair : _relations) {
            if (pair[0] == pair[1])
                continue;

            Node out = nodes.get(pair[0]);
            if (out == null) {
                out = new Node(pair[0]);
                nodes.put(pair[0], out);
            }
            out.out++;

            Node in = nodes.get(pair[1]);
            if (in == null) {
                in = new Node(pair[1]);
                nodes.put(pair[1], in);
            }
            in.in++;

            out.reachables.add(pair[1]);
        }

        // Find the root
        Node root = null;
        for (Node node : nodes.values()) {
            if (node.in == 0) {
                if (root == null)
                    root = node;
                else
                    throw new IllegalArgumentException("N-ary tree should only have one root!");
            }
        }

        // Topological sort
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int reachable : cur.reachables) {
                Node next = nodes.get(reachable);
                if (--next.in == 0) {
                    cur.children.add(next);
                    queue.offer(next);
                }
            }
        }

        return root;
    }

    private static class Node {
        final int val;
        List<Node> children;

        int in = 0;
        int out = 0;
        List<Integer> reachables;

        Node(final int val) {
            this.val = val;
            this.children = new ArrayList<>();
            this.reachables = new ArrayList<>();
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder("[" + val + "]");
            if (!children.isEmpty()) {
                builder.append(" -> ");
                for (Node node : children)
                    builder.append(node.val + ", ");
            }
            return builder.toString();
        }
    }
}
