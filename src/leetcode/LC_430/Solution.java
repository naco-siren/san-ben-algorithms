package leetcode.LC_430;

/**
 * 430. Flatten a Multilevel Doubly Linked List
 */
class Solution {
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
