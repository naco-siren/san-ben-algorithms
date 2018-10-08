package companies.google.xml_encode_tree;

import java.util.Stack;

/**
 * Created by naco_siren on 10/17/17.
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode("A");

        TreeNode n21 = new TreeNode("B");
        n1.children.add(n21);
        TreeNode n22 = new TreeNode("C");
        n1.children.add(n22);
        TreeNode n23 = new TreeNode("D");
        n1.children.add(n23);

        TreeNode n31 = new TreeNode("E");
        n21.children.add(n31);
        TreeNode n32 = new TreeNode("F");
        n21.children.add(n32);

        TreeNode n33 = new TreeNode("G");
        n22.children.add(n33);

        TreeNode n41 = new TreeNode("H");
        n33.children.add(n41);

        String r1 = solve(n1);
        String r2 = new Solution(n1).solve();
        // <a><b><e/><f/></b><c><g><h/></g></c><d/></a>

        return;
    }

    /**
     * Iterative solution
     */
    public static String solve(TreeNode root) {
        if (root == null) return null;

        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        Stack<Boolean> stack2 = new Stack<>();
        stack.push(root);
        stack2.push(true);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            Boolean isOpen = stack2.pop();

            if (isOpen == true) {
                if (node.children.isEmpty()) {
                    sb.append("<" + node.val + "/>");
                } else {
                    sb.append("<" + node.val + ">");

                    stack.push(node);
                    stack2.push(false);

                    for (int i = node.children.size() - 1; i >= 0; i--) {
                        stack.push(node.children.get(i));
                        stack2.push(true);
                    }

                }
            } else {
                sb.append("</" + node.val + ">");
            }

        }
        return sb.toString();
    }


    /**
     * Recursive solution
     */
    TreeNode _root;

    public Solution(TreeNode root) {
        this._root = root;
    }

    public String solve() {
        if (_root == null)
            return null;
        else
            return recur(_root);
    }

    private String recur(TreeNode node) {
        if (node.children.isEmpty()) {
            return "<" + node.val + "/>";
        } else {
            StringBuilder sb2 = new StringBuilder("<" + node.val + ">");
            for (TreeNode child : node.children)
                sb2.append(recur(child));
            sb2.append("</" + node.val + ">");
            return sb2.toString();
        }
    }


}
