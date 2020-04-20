package leetcode.LC_1008;

import base.TreeNode;

/**
 * 1008. Construct Binary Search Tree from Preorder Traversal
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0)
            return null;

        return recur(preorder, 0, preorder.length - 1);
    }

    TreeNode recur(final int[] preorder, final int start, final int end) {
        final int val = preorder[start];
        TreeNode node = new TreeNode(val);

        if (start < end) {
            int r = start + 1;
            while (r <= end && preorder[r] < val)
                r++;

            if (r - 1 >= start + 1)
                node.left = recur(preorder, start + 1, r - 1);
            if (r <= end)
                node.right = recur(preorder, r, end);
        }
        return node;
    }
}
