package liststackqueue.lc142;

import liststackqueue.lc23.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution142 {
    public ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            boolean flag = set.add(temp);
            if (!flag) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        // 初始化两个指针，fast 为快指针（每次移动两步），slow 为慢指针（每次移动一步）
        ListNode fast = head;  // 快指针
        ListNode slow = head;  // 慢指针
        // 当快指针 fast 及其下一个节点不为空时，继续循环
        boolean isExitCycle = false;
        while (fast != null && fast.next != null) {
            // 快指针每次移动两步
            fast = fast.next.next;
            // 慢指针每次移动一步
            slow = slow.next;
            // 如果快指针和慢指针相遇，说明链表中存在环
            if (fast == slow) {
                isExitCycle = true;
                break;
            }
        }
        // 如果遍历完整个链表，没有发现环，则返回 false
        if (!isExitCycle) {
            return null;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
