package leetcode.LC_257;

import base.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 257. Binary Tree Paths
 */
class Solution257 {
    List<String> binaryTreePaths(TreeNode root) {
        List<List<TreeNode>> results = new ArrayList<>();
        List<TreeNode> prefix = new ArrayList<>();
        helper(root, prefix, results);
        return format(results);
    }

    private void helper(TreeNode node, List<TreeNode> prefix, List<List<TreeNode>> results) {
        if (node == null)
            return;

        prefix.add(node);

        if (node.left == null && node.right == null) {
            results.add(new ArrayList<>(prefix));
        } else {
            helper(node.left, prefix, results);
            helper(node.right, prefix, results);
        }

        prefix.remove(prefix.size() - 1);
    }

    private List<String> format(List<List<TreeNode>> results) {
        List<String> output = new ArrayList<>();

        for (List<TreeNode> result : results) {
            if (result.isEmpty())
                continue;

            StringBuilder builder = new StringBuilder();

            Iterator<TreeNode> iterator = result.iterator();
            while (iterator.hasNext()) {
                TreeNode node = iterator.next();
                builder.append(node.val);
                if (iterator.hasNext())
                    builder.append("->");
            }

            output.add(builder.toString());
        }
        return output;
    }
}
