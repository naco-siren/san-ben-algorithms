package leetcode.LC_1026;

import base.TreeNode;

/**
 * 1026. Maximum Difference Between Node and Ancestor
 */
class Solution1026 {
    int maxDiff = 0;

    public int maxAncestorDiff(TreeNode root) {
        recur(root, root.val, root.val);
        return maxDiff;
    }

    private void recur(TreeNode node, int max, int min) {
        if (node == null)
            return;

        maxDiff = Math.max(maxDiff, Math.max(Math.abs(max - node.val), Math.abs(min - node.val)));
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        recur(node.left, max, min);
        recur(node.right, max, min);
    }
}
