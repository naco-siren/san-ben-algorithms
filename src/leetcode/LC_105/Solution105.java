package leetcode.LC_105;

import base.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 */
class Solution105 {
    TreeNode buildTree(int[] preorder, int[] inorder) {
        /* Use a HashMap for O(1) indexing */
        HashMap<Integer, Integer> inorderIndices = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inorderIndices.put(inorder[i], i);

        /* Recursively build the tree */
        return build(preorder, inorder, inorderIndices, 0, preorder.length, 0, inorder.length);
    }

    /**
     * The "l" and "r" here is the same as substring(start included, end excluded), i.e. slicing
     */
    private TreeNode build(
            final int[] preorder, final int[] inorder,
            final HashMap<Integer, Integer> inorderIndices,
            int l1, int r1, int l2, int r2) {
        /* Return if current sequence is empty */
        if (l1 == r1) return null;

        /* Find the root element's position in the inorder traverse */
        int val = preorder[l1];
        TreeNode root = new TreeNode(val);

        /* Recursion */
        int mid2 = inorderIndices.get(val);
        root.left = build(preorder, inorder, inorderIndices, l1 + 1, l1 + mid2 - l2 + 1, l2, mid2);
        root.right = build(preorder, inorder, inorderIndices, l1 + mid2 - l2 + 1, r1, mid2 + 1, r2);
        return root;
    }
}
