package twopointer.lc92;

import liststackqueue.lc23.ListNode;

public class Solution92 {
    // 考察头插法
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dumHead = new ListNode();
        dumHead.next = head;
        // 题目已经保证left和right范围合法
        ListNode reverseHead = new ListNode(); // 辅助头节点，哑节点
        ListNode begin = dumHead, end = null, tail = null;
        ListNode temp = head, nxt;
        int cnt = 1; // 表示当前的位置，即temp指针位置（不是以索引表示）
        while (cnt <= right + 1 && temp != null) {
            if (cnt == left - 1) {
                // 这句话在left=1的时候执行不到，所以说要做dumHead考虑
                begin = temp;
            }
            if (cnt == right + 1) {
                // 就算right就是末尾也无妨，此时temp已经等于null本身就是末尾值
                end = temp;
            }
            if (cnt >= left && cnt <= right) {
                if (reverseHead.next == null) {
                    tail = temp; // 第一个插入的节点，也是逆转链的尾部
                }
                nxt = temp.next; // 头插法要提前保存下一个
                temp.next = reverseHead.next;
                reverseHead.next = temp;
            } else {
                nxt = temp.next;
            }
            temp = nxt;
            cnt++;
        }
        begin.next = reverseHead.next;
        tail.next = end;
        return dumHead.next;
    }
}
