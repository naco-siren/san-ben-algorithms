package leetcode.LC_1123;

import base.TreeNode;

/**
 * 1123. Lowest Common Ancestor of Deepest Leaves
 */
class Solution1123 {

    int deepest = 0;
    TreeNode lca;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        helper(root, 0);
        return lca;
    }

    private int helper(TreeNode node, final int depth) {
        // Pre-order update `deepest` record
        deepest = Math.max(deepest, depth);

        // Note that we return current depth upon null,
        if (node == null)
            return depth;
        // ...which means that null children of leaves are still considered as a level here.
        // (i.e. actual depth is 1 bigger than problem's definition)

        int left = helper(node.left, depth + 1);
        int right = helper(node.right, depth + 1);

        // Post-order check for LCA!
        if (left == deepest && right == deepest)
            lca = node;

        return Math.max(left, right);
    }

    /**
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */

    TreeNode target = null;
    int maxDepth = 0;

    public TreeNode lcaDeepestLeavesTwoPasses(TreeNode root) {
        maxDepth = findMaxDepth(root);

        dfs(root, 0);

        return target;
    }

    private int findMaxDepth(TreeNode node) {
        if (node == null)
            return -1;

        final int leftDepth = findMaxDepth(node.left);
        final int rightDepth = findMaxDepth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    private boolean dfs(TreeNode node, int depth) {
        if (node == null)
            return false;

        if (depth == maxDepth) {
            target = node;
            return true;
        }


        boolean leftLeaf = dfs(node.left, depth + 1);
        boolean rightLeaf = dfs(node.right, depth + 1);

        if (leftLeaf && rightLeaf) {
            target = node;
            return true;
        }

        return leftLeaf || rightLeaf;
    }
}
