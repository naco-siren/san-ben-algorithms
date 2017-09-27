package leetcode.LC_105;

import base.TreeNode;

import java.util.Arrays;

/**
 * Created by naco_siren on 7/30/17.
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode r1 = buildTree(new int[]{1, 2}, new int[]{2, 1});

        return;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    private static TreeNode build(final int[] preorder, final int[] inorder, int l1, int r1, int l2, int r2) {
        if (l1 == r1) return null;

        int val = preorder[l1];
        TreeNode root = new TreeNode(val);

        int mid2 = Arrays.binarySearch(inorder, l2, r2, val);
        root.left = build(preorder, inorder, l1 + 1, l1 + mid2 - l2 + 1, l2, mid2);
        root.right = build(preorder, inorder, l1 + mid2 - l2 + 1, r1, mid2 + 1, r2);
        return root;
    }
}
