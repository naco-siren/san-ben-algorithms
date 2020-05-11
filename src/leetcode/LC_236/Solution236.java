package leetcode.LC_236;

import base.TreeNode;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 */
class Solution236 {
    /**
     * The best approach to directly return the LCA
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);

        if (left != null && right != null)
            return root;
        else
            return left != null ? left : right;
    }


    /**
     * Another approach that returns an int value
     */
    TreeNode lowestCommonAncestorRecurInt(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, p, q);
        return result;
    }

    TreeNode result = null;

    private int traverse(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return 0;

        // If left already found both
        final int left = traverse(root.left, p, q);
        if (left == 2)
            return 2;

        // If right already found both
        final int right = traverse(root.right, p, q);
        if (right == 2)
            return 2;

        // If current node is one of the targets
        final int mid = root == p || root == q ? 1 : 0;

        // If current node is LCA
        final int total = mid + left + right;
        if (total == 2)
            result = root;

        return total;
    }
}
