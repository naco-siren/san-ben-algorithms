package leetcode.LC_938;

import base.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 938. Range Sum of BST
 */
class Solution938 {
    int rangeSumBST(TreeNode root, int L, int R) {
        AtomicInteger sum = new AtomicInteger(0);

        rangeSumBST(root, L, R, sum);

        return sum.get();
    }

    private void rangeSumBST(final TreeNode root, final int L, final int R, AtomicInteger sum) {
        if (root == null)
            return;

        if (root.val >= L && root.val <= R)
            sum.set(sum.get() + root.val);

        rangeSumBST(root.left, L, R, sum);
        rangeSumBST(root.right, L, R, sum);
    }
}
