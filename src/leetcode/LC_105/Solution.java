package leetcode.LC_105;

import base.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by naco_siren on 7/30/17.
 */
public class Solution {
    public static void main(String[] args) {
        /*
         *      4
         *     / \
         *    2   5
         *   /\
         *  1 3
         */
        TreeNode r1 = buildTree(new int[]{4, 2, 1, 3, 5}, new int[]{1, 2, 3, 4, 5});

        return;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        /* Use a HashMap for O(1) indexing */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        /* Recursively build the tree */
        return build(preorder, inorder, map, 0, preorder.length, 0, inorder.length);
    }

    /**
     * The "l" and "r" here is the same as substring(start, end), i.e. slicing
     */
    private static TreeNode build(
            final int[] preorder, final int[] inorder, final HashMap<Integer, Integer> map,
            int l1, int r1, int l2, int r2) {
        /* Return if current sequence is empty */
        if (l1 == r1) return null;

        /* Find the root element's position in the inorder traverse */
        int val = preorder[l1];
        TreeNode root = new TreeNode(val);

        /* Recursion */
        int mid2 = map.get(val);
        root.left = build(preorder, inorder, map, l1 + 1, l1 + mid2 - l2 + 1, l2, mid2);
        root.right = build(preorder, inorder, map, l1 + mid2 - l2 + 1, r1, mid2 + 1, r2);
        return root;
    }
}
