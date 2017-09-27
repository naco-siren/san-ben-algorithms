package leetcode.LC_108;

import base.TreeNode;

/**
 * Created by naco_siren on 8/2/17.
 */
public class Solution {
    public static void main(String[] args) {

        TreeNode r1 = sortedArrayToBST(new int[]{1, 3});

        return;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return build(nums, 0, nums.length);
    }

    private static TreeNode build(int[] nums, int left, int right) {
        if (left == right)
            return null;

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, left, mid);
        node.left = build(nums, mid+1, right);
        return node;
    }
}
