package leetcode;

import base.TreeNode;

/**
 * Created by naco_siren on 8/2/17.
 */
public class LC_108 {
    public static void main(String[] args) {
        LC_108 lc = new LC_108();

        int[] arr1 = new int[]{1, 3};
        TreeNode root = lc.sortedArrayToBST(arr1);

        return;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return build(nums, 0, nums.length);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left == right)
            return null;

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, left, mid);
        node.left = build(nums, mid+1, right);
        return node;
    }
}
