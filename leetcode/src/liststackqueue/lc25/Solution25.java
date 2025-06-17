package liststackqueue.lc25;

import liststackqueue.lc23.ListNode;

public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0, cnt = 0;
        ListNode dumHead = new ListNode(0, head);
        ListNode reverseHead = new ListNode();
        ListNode temp = dumHead.next;
        ListNode cur = null;
        ListNode first = null;
        ListNode last = dumHead;
        // O(n)
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        temp = dumHead.next;
        // 虽然有嵌套循环，实际还是O(n)
        while (len - cnt >= k) {
            first = temp;
            for (int i = 0; i < k; i++) {
                cur = temp.next; // 先把temp.next保存一下
                temp.next = reverseHead.next;
                reverseHead.next = temp;
                temp = cur;
                cnt++;
            }
            first.next = temp;
            last.next = reverseHead.next;
            last = first;
            reverseHead.next = null;
        }
        return dumHead.next;
    }
}
