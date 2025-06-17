package liststackqueue.lc328;

import liststackqueue.lc23.ListNode;

public class Main328 {
    public static void main(String[] args) {
        // 题目 [2,1,3,5,6,4,7]
        // 预期 [2,3,6,7,1,5,4]
        ListNode head = new ListNode(2, new ListNode
                (1, new ListNode
                        (3, new ListNode
                                (5, new ListNode(6, new ListNode
                                        (4, new ListNode(7)))))));
        Solution328 s328 = new Solution328();
        ListNode retHead = s328.oddEvenList(head);
        System.out.println(retHead.val);
    }
}
