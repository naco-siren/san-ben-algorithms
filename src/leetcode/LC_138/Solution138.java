package leetcode.LC_138;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 */
class Solution138 {
    Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        return copyRandomListNode(head, map);
    }

    private Node copyRandomListNode(Node src, Map<Node, Node> map) {
        if (src == null)
            return null;

        Node target = map.get(src);
        if (target != null)
            return target;

        target = new Node(src.val);
        map.put(src, target);

        target.next = copyRandomListNode(src.next, map);
        target.random = copyRandomListNode(src.random, map);

        return target;
    }

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
