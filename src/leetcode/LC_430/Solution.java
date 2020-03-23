package leetcode.LC_430;

import java.util.Stack;

/**
 * 430. Flatten a Multilevel Doubly Linked List
 */
class Solution {
    public NodeWithChild flattenIteration(NodeWithChild head) {
        if (head == null)
            return null;

        // Initialize a stack
        Stack<NodeWithChild> stack = new Stack<>();
        stack.push(head);

        NodeWithChild pre = null;
        NodeWithChild current;
        while (!stack.isEmpty()) {
            current = stack.pop();

            // Push `next` first so that `child` gets popped first
            if (current.next != null)
                stack.push(current.next);
            if (current.child != null)
                stack.push(current.child);

            // Concatenate double-linked list
            if (pre != null) {
                pre.next = current;
                current.prev = pre;
            }

            current.child = null;
            pre = current;
        }

        return head;
    }

    public NodeWithChild flatten(NodeWithChild head) {
        NodeWithChild sentinel = new NodeWithChild();
        sentinel.next = head;
        flatternRecur(sentinel.next);
        return sentinel.next;
    }

    private NodeWithChild flatternRecur(NodeWithChild cur) {
        if (cur == null)
            return null;

        NodeWithChild next = cur.next, child = cur.child;

        if (child != null) {
            NodeWithChild tail = flatternRecur(child);

            cur.next = child;
            child.prev = cur;

            if (next != null) {
                tail.next = next;
                next.prev = tail;
            }

            cur.child = null;
            return flatternRecur(next);
        }

        if (next != null) {
            return flatternRecur(next);
        } else {
            return cur;
        }
    }

    private static class NodeWithChild {
        public int val;
        public NodeWithChild prev;
        public NodeWithChild next;
        public NodeWithChild child;
    };
}
