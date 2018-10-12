package leetcode.LC_092;

import base.ListNode;

public class Solution {
    public static void main(String[] args) {
        // 1->2->3->4->5->NULL
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2); n1.next = n2;
        ListNode n3 = new ListNode(3); n2.next = n3;
        ListNode n4 = new ListNode(4); n3.next = n4;
        ListNode n5 = new ListNode(5); n4.next = n5;

        ListNode r1 = reverseBetween(n1, 2, 4); // 1->4->3->2->5->NULL
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;

        ListNode sentinel = new ListNode(0), tail = sentinel;
        ListNode cur = head, next;
        ListNode revHead = null, revTail = null;

        for (int k = 1; k <= n; k++, cur = next) {
            next = cur.next;

            if (k < m) {
                tail.next = cur;
                tail = tail.next;
            } else {
                if (revTail == null)
                    revTail = cur;      // Assign revTail once
                cur.next = revHead;     // and then append using revHead
                revHead = cur;
            }
        }

        tail.next = revHead;
        revTail.next = cur;
        return sentinel.next;
    }
}
