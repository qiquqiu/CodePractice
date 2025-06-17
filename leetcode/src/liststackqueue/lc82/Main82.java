package liststackqueue.lc82;

import liststackqueue.lc23.ListNode;

public class Main82 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        // head = [1,2,3,3,4,4,5]
        Solution82 s82 = new Solution82();
        ListNode retNode = s82.deleteDuplicates(new ListNode(1, new ListNode(1)));
        System.out.println(retNode.val);
    }
}
