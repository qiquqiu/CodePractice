package liststackqueue.lc143;

import liststackqueue.lc23.ListNode;

import java.util.Stack;

public class Solution143 {
    // 找中点、断开、反转后半段、拼接
    public void reorderList1(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        int length = 0, mid = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        // 获取length的地方可以用双指针快慢指针法简化
        mid = length % 2 == 0 ? length / 2 : length / 2 + 1;
        Stack<ListNode> stack = new Stack<>();
        temp = head;
        for (int i = 0; i < mid - 1; i++) {
            temp = temp.next;
        }
        while (temp.next != null) {
            stack.push(temp.next);
            temp.next = temp.next.next;
        }
        temp = head;
        ListNode popped;
        while (!stack.isEmpty()) {
            popped = stack.pop();
            popped.next = temp.next;
            temp.next = popped;
            // 由于statck的节点数目永远小于等于剩余的节点数目，所以说下面这里不会报null错误
            // 第一次next是移到刚刚加上去的节点处，第二次next才是移到实际上原序列的“下一个”
            temp = temp.next.next;
        }
    }
}
