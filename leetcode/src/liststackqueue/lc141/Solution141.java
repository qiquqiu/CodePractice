package liststackqueue.lc141;

import liststackqueue.lc23.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution141 {
    /*  作者：天行健
        链接：https://leetcode.cn/problems/linked-list-cycle/solutions/2931387/jian-dan-yi-dong-huan-xing-lian-biao-by-56z1g/
        来源：力扣（LeetCode）
        双指针之快慢指针法：凡是有环，找环，一般都可以使用快慢指针法
    */
    public boolean hasCycle(ListNode head) {
        // 初始化两个指针，fast 为快指针（每次移动两步），slow 为慢指针（每次移动一步）
        ListNode fast = head;  // 快指针
        ListNode slow = head;  // 慢指针
        // 当快指针 fast 及其下一个节点不为空时，继续循环
        while (fast != null && fast.next != null) {
            // 快指针每次移动两步
            fast = fast.next.next;
            // 慢指针每次移动一步
            slow = slow.next;
            // 如果快指针和慢指针相遇，说明链表中存在环
            if (fast == slow) {
                return true;
            }
        }
        // 如果遍历完整个链表，没有发现环，则返回 false
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            boolean isAddSucceed = set.add(temp);
            if (!isAddSucceed) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
