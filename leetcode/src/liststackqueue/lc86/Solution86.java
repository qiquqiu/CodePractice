package liststackqueue.lc86;

import liststackqueue.lc23.ListNode;

public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        // 双指针指向两个链表的尾部，这样可以使添加节点达到O(1)
        // 之所以还要保留虚拟头节点是为了后面的链接
        ListNode h1 = new ListNode();
        ListNode ptr1 = h1;
        ListNode h2 = new ListNode();
        ListNode ptr2 = h2;
        ListNode temp = head;
        ListNode next = null;
        while (temp != null) {
            // 因为要置空，所以提前保存next域
            next = temp.next;
            // 移动添加节点之前一定将节点next域置空，防止最后一个节点处有成环可能
            temp.next = null;
            if (temp.val < x) {
                ptr1.next = temp;
                ptr1 = ptr1.next;
            } else {
                ptr2.next = temp;
                ptr2 = ptr2.next;
            }
            temp = next;
        }
        ptr1.next = h2.next;
        return h1.next;
    }
}
