package leetcode.LC_199;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. Binary Tree Right Side View
 */
class Solution199 {
    List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recur(root, 0, result);
        return result;
    }

    private void recur(final TreeNode node, final int depth, List<Integer> result) {
        if (node == null)
            return;

        if (result.size() > depth) {
            result.set(depth, node.val);
        } else {
            result.add(node.val);
        }
        recur(node.left, depth + 1, result);
        recur(node.right, depth + 1, result);
    }
}
