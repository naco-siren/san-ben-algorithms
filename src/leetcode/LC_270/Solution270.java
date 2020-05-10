package leetcode.LC_270;

import base.TreeNode;

/**
 * 270. Closest Binary Search Tree Value
 */
class Solution270 {
    Integer candidate = null;
    Double minDiff = null;

    public int closestValue(TreeNode root, double target) {
        recur(root, target);
        return candidate;
    }

    private void recur(TreeNode node, final double target) {
        if (node == null)
            return;

        // Update candidate if diff smaller than minDiff
        double absDiff = Math.abs(node.val - target);
        if (minDiff == null || absDiff < minDiff) {
            candidate = node.val;
            minDiff = absDiff;
        }

        // Recursion w/ pruning
        if (target > node.val) {
            recur(node.right, target);
        } else  {
            recur(node.left, target);
        }
    }
}
