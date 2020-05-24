package leetcode.LC_426;

/**
 * 426. Convert Binary Search Tree to Sorted Doubly Linked List
 */
class Solution426 {
    Node treeToDoublyList(Node root) {
        if (root == null)
            return null;

        Node[] range = helper(root);

        range[0].left = range[range.length - 1];
        range[range.length - 1].right = range[0];
        return range[0];
    }

    private Node[] helper(Node node) {
        Node[] range = new Node[2];

        if (node.left != null) {
            Node[] left = helper(node.left);

            left[1].right = node;
            node.left = left[1];

            range[0] = left[0];
        } else {
            range[0] = node;
        }

        if (node.right != null) {
            Node[] right = helper(node.right);

            right[0].left = node;
            node.right = right[0];

            range[1] = right[1];
        } else {
            range[1] = node;
        }

        return range;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
