package liststackqueue.lc147;

import liststackqueue.lc23.ListNode;

public class Main147 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(8);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Solution147 s147 = new Solution147();
        ListNode retHead = s147.insertionSortList(head);
        System.out.println(retHead.val);
    }
}
