package leetcode.LC_117;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 117. Populating Next Right Pointers in Each Node II
 */
class Solution117 {
    Node connect(Node root) {
        Node head = root;   // Head of each level
        while (head != null) {
            Node tail = head;   // `tail` probes current level to the end
            Node prev = null;   // `prev` is the previous non-null node on the next level
            Node nextHead = null;

            while (tail != null) {
                if (tail.left != null) {
                    if (prev != null)
                        prev.next = tail.left;
                    if (nextHead == null)
                        nextHead = tail.left;   // Memorize the first non-null node on the next level, as the next level's head, i.e. `nextHead`
                    prev = tail.left;
                }

                if (tail.right != null) {
                    if (prev != null)
                        prev.next = tail.right;
                    if (nextHead == null)
                        nextHead = tail.right;  // Ditto.
                    prev = tail.right;
                }

                tail = tail.next;
            }
            head = nextHead;
        }
        return root;
    }

    Node connectWithQueue(Node root) {
        Queue<Node> thisLevel = new LinkedList<>();
        if (root != null)
            thisLevel.offer(root);

        while (!thisLevel.isEmpty()) {
            Queue<Node> nextLevel = new LinkedList<>();

            Node prev = null;
            while (!thisLevel.isEmpty()) {
                Node node = thisLevel.poll();
                if (prev != null)
                    prev.next = node;
                prev = node;

                if (node.left != null)
                    nextLevel.offer(node.left);
                if (node.right != null)
                    nextLevel.offer(node.right);
            }

            thisLevel = nextLevel;
        }

        return root;
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
