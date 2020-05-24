package leetcode.LC_426;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution426Test {

    @Test
    public void treeToDoublyList_4_2_5_1_3() {
        Solution426.Node n31 = new Solution426.Node(1);
        Solution426.Node n32 = new Solution426.Node(3);
        Solution426.Node n21 = new Solution426.Node(2); n21.left = n31; n21.right = n32;
        Solution426.Node n22 = new Solution426.Node(5);
        Solution426.Node n11 = new Solution426.Node(4); n11.left = n21; n11.right = n22;

        Solution426.Node r1 = new Solution426().treeToDoublyList(n11);

        Solution426.Node tail = r1;
        assertEquals(1, tail.val); tail = tail.right;
        assertEquals(2, tail.val); tail = tail.right;
        assertEquals(3, tail.val); tail = tail.right;
        assertEquals(4, tail.val); tail = tail.right;
        assertEquals(5, tail.val); tail = tail.right;
        assertEquals(1, tail.val);

        tail = r1;
        assertEquals(1, tail.val); tail = tail.left;
        assertEquals(5, tail.val); tail = tail.left;
        assertEquals(4, tail.val); tail = tail.left;
        assertEquals(3, tail.val); tail = tail.left;
        assertEquals(2, tail.val); tail = tail.left;
        assertEquals(1, tail.val);
    }
}