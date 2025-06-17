package liststackqueue.lc82;

import liststackqueue.lc23.ListNode;

public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        // 测试用例： head = [1,2,3,3,4,4,5]
        if (head == null || head.next == null) {
            return head;
        }
        int[] cnt = new int[201]; // 0:-100 1:-99 100:0 200:100
        ListNode temp = head;
        while (temp != null) {
            cnt[temp.val + 100]++;
            temp = temp.next;
        }
        ListNode dumHead = new ListNode();
        dumHead.next = head;
        ListNode pre = dumHead;
        temp = head;
        while (temp != null && temp.next != null) {
            if (cnt[temp.val + 100] > 1) {
                int loop = cnt[temp.val + 100];
                for (int i = 0; i < loop; i++) {
                    temp = temp.next;
                    pre.next = temp;
                }
            } else {
                pre = temp;
                temp = temp.next;
            }
        }
        return dumHead.next;
    }
}
