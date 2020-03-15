package leetcode.LC_445;

import base.ListNode;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static leetcode.LC_445.Solution.addTwoNumbers;

public class SolutionTest {

    @Test
    public void addTwoNumbers_7243_564() {
        ListNode l11 = new ListNode(7);
        ListNode l12 = new ListNode(2); l11.next = l12;
        ListNode l13 = new ListNode(4); l12.next = l13;
        ListNode l14 = new ListNode(3); l13.next = l14;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6); l21.next = l22;
        ListNode l23 = new ListNode(4); l22.next = l23;

        ListNode r1 = addTwoNumbers(l11, l21);
        assertEquals(7, r1.val);
        r1 = r1.next;
        assertEquals(8, r1.val);
        r1 = r1.next;
        assertEquals(0, r1.val);
        r1 = r1.next;
        assertEquals(7, r1.val);
    }
}
