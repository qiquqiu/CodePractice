package twopointer.lc19;

import twopointer.lc24.ListNode;

public class Solution19 {
    // 题目：删除单链表的倒数第n个节点
    // 首先是普通的方法，也就是一遍扫描还不足够
    // 但是时间复杂度好像也不高？！也是 O(n)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode mhead = new ListNode(0, head);
        ListNode temp = mhead.next;
        int len = 0;
        // 先遍历一遍，获取到链表长度
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        temp = mhead;
        // 然后再从头开始遍历len-n次(即temp移动次数)即到待删节点之前
        for (int i = 0; i < len - n; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return mhead.next;
    }
}
