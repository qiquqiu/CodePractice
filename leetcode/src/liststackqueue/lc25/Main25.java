package liststackqueue.lc25;

import liststackqueue.lc23.ListNode;

public class Main25 {
    public static void main(String[] args) {
        Solution25 s25 = new Solution25();
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode retNode = s25.reverseKGroup(n1, 2);
        System.out.println(retNode.val);
    }
}
