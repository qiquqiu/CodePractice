package liststackqueue.lc148;

import liststackqueue.lc23.ListNode;

public class Main148 {
    // https://yiyan.baidu.com/share/pLRLlguCt9?utm_invite_code=Ttc%2Fsg8ukRZC8pcM4VpaMw%3D%3D&utm_name=MTMyKioqKioqNjA%3D&utm_fission_type=common
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
        Solution148_merge s148 = new Solution148_merge();
        ListNode retHead = s148.sortList(head);
        System.out.println(retHead.val);
    }
}
