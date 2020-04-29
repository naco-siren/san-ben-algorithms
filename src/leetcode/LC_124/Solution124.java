package leetcode.LC_124;

import base.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 124. Binary Tree Maximum Path Sum
 */
public class Solution124 {
    public int maxPathSum(TreeNode root) {
        AtomicInteger maxSum = new AtomicInteger(Integer.MIN_VALUE);
        maxPathSumTraverse(root, maxSum);
        return maxSum.get();
    }

    private int maxPathSumTraverse(TreeNode root, AtomicInteger maxSum) {
        if (root == null)
            return 0;

        final int left = Math.max(0, maxPathSumTraverse(root.left, maxSum));
        final int right = Math.max(0, maxPathSumTraverse(root.right, maxSum));
        maxSum.set(Math.max(maxSum.get(), left + root.val + right));

        return Math.max(left + root.val, right + root.val);
    }
}
