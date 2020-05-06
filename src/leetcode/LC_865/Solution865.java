package leetcode.LC_865;

import base.TreeNode;

/**
 * 865. Smallest Subtree with all the Deepest Nodes
 */
public class Solution865 {
    private int maxDepth = 0;
    private TreeNode target;

    TreeNode subtreeWithAllDeepest(TreeNode root) {
        traverseTree(root, 1);
        return target;
    }

    private int traverseTree(final TreeNode node, final int depth) {
        if (node == null)
            return 0;

        final int leftDepth = traverseTree(node.left, depth + 1);
        final int rightDepth = traverseTree(node.right, depth + 1);
        final int pathDepth = depth + Math.max(leftDepth, rightDepth);

        // Post-order
        if (pathDepth > maxDepth) {
            maxDepth = pathDepth;
            target = node;
        } else if (pathDepth == maxDepth) {
            if (leftDepth == rightDepth) {
                target = node;
            }
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
