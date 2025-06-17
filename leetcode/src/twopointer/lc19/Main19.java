package twopointer.lc19;

import twopointer.lc24.ListNode;

public class Main19 {
    public static void main(String[] args) {
        System.out.println("第一种方法：不能够一次遍历完成");
        ListNode head = new ListNode(1);
        Solution19 solution19 = new Solution19();
        ListNode resHeadNode = solution19.removeNthFromEnd(head, 1);
        System.out.println(resHeadNode == null ? "null" : resHeadNode.val);

        System.out.println("第二种方法：能够一次遍历完成");
        Solution19_2 solution19_2 = new Solution19_2();
        ListNode res2 = solution19_2.removeNthFromEnd(head, 1);
        System.out.println(res2 == null ? "null" : res2.val);
    }
}
