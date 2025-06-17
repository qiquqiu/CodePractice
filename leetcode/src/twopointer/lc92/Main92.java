package twopointer.lc92;

import liststackqueue.lc23.ListNode;

public class Main92 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Solution92 s92 = new Solution92();
        ListNode retHead = s92.reverseBetween(head, 2, 4);
        System.out.println(retHead.val);
    }
}
