package leetcode.LC_716;

import base.DoubleLinkedList;

import java.util.LinkedList;
import java.util.TreeMap;

/**
 * 716. Max Stack
 *
 * using a TreeMap {val -> [candidate nodes] } and a Double-linked list
 */
class Solution716DLL {
    TreeMap<Integer, LinkedList<DoubleLinkedList.Node>> map;
    DoubleLinkedList dll;

    public Solution716DLL() {
        map = new TreeMap<>();
        dll = new DoubleLinkedList();
    }

    public void push(int x) {
        DoubleLinkedList.Node node = dll.add(x);
        if (!map.containsKey(x))
            map.put(x, new LinkedList<>());
        map.get(x).add(node);
    }

    public int pop() {
        int val = dll.pop();

        LinkedList<DoubleLinkedList.Node> L = map.get(val);
        L.removeLast();
        if (L.isEmpty())
            map.remove(val);

        return val;
    }

    public int top() {
        return dll.peek();
    }

    public int peekMax() {
        return map.lastKey();
    }

    public int popMax() {
        final int max = peekMax();

        LinkedList<DoubleLinkedList.Node> L = map.get(max);
        DoubleLinkedList.Node node = L.removeLast();
        if (L.isEmpty())
            map.remove(max);

        dll.unlink(node);

        return max;
    }
}