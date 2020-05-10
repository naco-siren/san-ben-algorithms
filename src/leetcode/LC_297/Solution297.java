package leetcode.LC_297;

import base.TreeNode;

import java.util.Stack;

/**
 * 297. Serialize and Deserialize Binary Tree
 */
public class Solution297 {
    private static final char NULL_ESCAPE = '#';
    private static final char VALUE_ESCAPE = '@';

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            final TreeNode node = stack.pop();
            if (node == null) {
                builder.append(NULL_ESCAPE);
            } else {
                builder.append(node.val);
                builder.append(VALUE_ESCAPE);

                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return builder.toString();
    }

    private int offset;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        offset = 0;
        return deserializeNode(data);
    }

    private TreeNode deserializeNode(String data) {
        // Check for null
        if (data.charAt(offset) == NULL_ESCAPE) {
            offset++;
            return null;
        }

        // Parse non-null int value.
        int i = offset;
        while (i < data.length() && data.charAt(i) != VALUE_ESCAPE)
            i++;
        final int val = Integer.parseInt(data.substring(offset, i));
        offset = i + 1;

        // Recursively reconstruct TreeNode.
        TreeNode node = new TreeNode(val);
        node.left = deserializeNode(data);
        node.right = deserializeNode(data);
        return node;
    }
}
