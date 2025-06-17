package liststackqueue.lc328;

import liststackqueue.lc23.ListNode;

public class Solution328 {
    // 链表抽离奇偶链表再合并
    // 双指针解法，时间复杂度O(n)，空间复杂度O(1)解法
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 这里得额外保存一下偶链表的头指针
        ListNode odd = head, even = head.next, evenHead = head.next;
        // 对于链表长度为奇数，正常遍历就可以了，结束的时候刚好odd指针指向的就是奇链表的尾节点而非null，偶指针也刚好指向的是null；
        // 但是对于偶数长度的链表，不仅仅需要通过最后一步的特殊判定使得偶指针even能成功指向null（防止成环）
        // 还要使得odd指针不要移动最后一步防止成为null，使我们失去奇链表尾指针的定位
        while (even != null) {
            odd.next = odd.next.next;
            if (even.next != null) {
                even.next = even.next.next;
            } else {
                // 偶数长度时，最后一步将进入else执行
                even = even.next;
                // 不让odd继续向下成为null了
                break;
            }
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
