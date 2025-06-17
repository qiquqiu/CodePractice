package liststackqueue.lc234;

import liststackqueue.lc23.ListNode;

public class Main234 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Solution234_tp s234tp = new Solution234_tp();
        boolean flag = s234tp.isPalindrome(head);
        System.out.println((flag ? "是回文" : "不是回文") + "链表");
    }
}
