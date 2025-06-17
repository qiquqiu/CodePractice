package liststackqueue.lc234;

import liststackqueue.lc23.ListNode;

public class Solution234_tp2 {
    // 第二种双指针解法：“头插法”再逆转比较
    // 这种方法由于每次sb对象都是保存整个链那么长度的内容，
    // 所以后续比较时候一定比第一种快慢指针只保存半链长度内容要耗时更长
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 由于头插法逆转链表是操作于原链表节点，所以要先保存原链表
        ListNode temp = head;
        StringBuilder sb1 = new StringBuilder();
        while (temp != null) {
            sb1.append(temp.val);
            temp = temp.next;
        }
        temp = head;
        ListNode nxt;
        ListNode reverseHead = new ListNode();
        while (temp != null) {
            nxt = temp.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = nxt;
        }
        temp = reverseHead.next;
        StringBuilder sb2 = new StringBuilder();
        while (temp != null) {
            sb2.append(temp.val);
            temp = temp.next;
        }
        return sb1.toString().equals(sb2.toString());
    }
}
