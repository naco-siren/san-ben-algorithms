package leetcode.LC_146;

import java.util.HashMap;

/**
 * 146. LRU Cache
 */
public class LRUCache {
    private int mCapacity;
    private HashMap<Integer, Node> mMap;
    private Node mHead;
    private Node mTail;

    public LRUCache(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Capacity must be at least 1.");

        mCapacity = capacity;

        mMap = new HashMap<>();

        mHead = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
        mTail = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
        mHead.next = mTail;
        mTail.prev = mHead;
    }

    private Node getNode(Integer key) {
        Node node = mMap.get(key);
        if (node != null) {
            removeNode(node);
            appendToTail(node);
        }
        return node;
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;

        node.prev = null;
        node.next = null;

        mMap.remove(node.key);
    }

    private void appendToTail(Node node) {
        Node prev = mTail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = mTail;
        mTail.prev = node;

        mMap.put(node.key, node);
    }

    public int get(int key) {
        Node node = getNode(key);
        return node != null ? node.val : -1;
    }

    public void put(int key, int value) {
        Node node = getNode(key);

        if (node != null) {
            node.val = value;
        } else {
            // Remove if necessary
            Node recycled = null;
            if (mMap.size() == mCapacity) {
                recycled = mHead.next;
                removeNode(recycled);
            }

            // Appending to tail
            if (recycled != null) {
                recycled.key = key;
                recycled.val = value;
            } else {
                recycled = new Node(key, value);
            }
            appendToTail(recycled);
        }
    }

    private static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
