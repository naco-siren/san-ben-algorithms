package leetcode.LC_314;

import base.TreeNode;

import java.util.*;

/**
 * 314. Binary Tree Vertical Order Traversal
 */
class Solution314 {
    /**
     *
     * Time Complexity: O(N), N: the number of nodes in the tree
     * Space Complexity: O(N).
     *
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> results = new HashMap<>();
        int minCol = 0;
        int maxCol = 0;

        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> colQ = new LinkedList<>();
        if (root != null) {
            nodeQ.offer(root);
            colQ.offer(0);
        }

        while (!nodeQ.isEmpty()) {
            final TreeNode node = nodeQ.poll();
            final Integer col = colQ.poll();

            results.computeIfAbsent(col, x -> new ArrayList<>()).add(node.val);

            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);

            if (node.left != null) {
                nodeQ.offer(node.left);
                colQ.offer(col - 1);
            }
            if (node.right != null) {
                nodeQ.offer(node.right);
                colQ.offer(col + 1);
            }
        }

        List<List<Integer>> output = new ArrayList<>();
        for (int i = minCol; i <= maxCol; i++) {
            List<Integer> result = results.get(i);
            if (result != null)
                output.add(result);
        }
        return output;
    }
}
