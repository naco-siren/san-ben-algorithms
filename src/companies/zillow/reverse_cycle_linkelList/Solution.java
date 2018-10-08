package com.nacosiren.reverse_cycle_linkelList;

/**
 * Created by naco_siren on 10/3/17.
 */
public class Solution {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n1;


        reverseCycleLinkedList(n1);

        return;
    }

    public static void reverseCycleLinkedList(ListNode head){
        /* Split the link from head's parent to head */
        for (ListNode cur = head; cur != null; cur = cur.next)
            if (cur.next == head)
                cur.next = null;

        /* Reverse the linkedlist */
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        for (ListNode cur = head; cur.next != null;) {
            ListNode next = cur.next;
            cur.next = next.next;

            next.next = sentinel.next;
            sentinel.next = next;
        }

        /* Connect original head to new head */
        head.next = sentinel.next;
    }

}


class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}