package twopointer.lc19;

import twopointer.lc24.ListNode;

public class Solution19_2 {
    // 进阶的方法：双指针法（快慢指针法），一次遍历即可完成
    // 虽然进行了两次循环，但是注意fast（或者说slow）只有向前没有回退
    // 所以整体看就是遍历了一次，故时间复杂度为 O(n)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 思路：两个指针slow和fast，其中fast开始就要领先slow指针n个节点的间距
        // 也就是说，当开始时slow指向head，则fast指向head后的第n个节点
        // 那么当fast指针先指向最后的节点之时，slow刚好指向待删除节点（倒数第n个节点）
        // 的前一个节点，从而直接完成删除
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        for (int i = 0; i < n; i++) {
            // 循环n次，使得fast指针指向slow后的第n个节点
            fast = fast.next;
        }
        if (fast == null) {
            // 如果fast指针已经指向null，说明删除的是头节点，直接返回head.next即可
            // 这个特殊情况是避免不了的，如果合并进入while，则相应的间距要增大一个
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
