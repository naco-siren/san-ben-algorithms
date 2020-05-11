package leetcode.LC_106;

import base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 */
class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Construct a map of inorder's indices for O(1) access
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inorderMap.put(inorder[i], i);

        return buildNode(inorder, postorder, inorderMap, 0, inorder.length, 0, postorder.length);
    }

    /**
     * The "s" and "e" here is the same as substring(start included, end excluded), i.e. slicing
     */
    private TreeNode buildNode(
            int[] inorder, int[] postorder, Map<Integer, Integer> inorderMap,
            final int inS, final int inE, final int postS, final int postE
    ) {
        /* Return if current sequence is empty */
        if (postS == postE)
            return null;

        /* Find the root element's position in the inorder traverse */
        final int val = postorder[postE - 1];

        /* Decide the lengths of left subarray and right subarray */
        final int mid = inorderMap.get(val);
        final int leftLen = mid - inS, rightLen = inE - (mid + 1);

        /* Recursion */
        final TreeNode node = new TreeNode(val);
        node.left = buildNode(inorder, postorder, inorderMap, inS, mid, postS, postS + leftLen);
        node.right = buildNode(inorder, postorder, inorderMap, mid + 1, inE, postS + leftLen, postE - 1);
        return node;
    }
}
