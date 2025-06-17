package liststackqueue.lc147;

import liststackqueue.lc23.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution147 {
    // 对链表进行插入排序，直观解法：链表->拆为数组节点->排序->重组为链表
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        // 插入排序O(n^2) （甚至可以直接Arrays.sort）
        for (int i = 0; i < list.size() - 1; i++) {
            ListNode insertVal = list.get(i + 1);
            int destIndex = i;
            while (destIndex >= 0 && insertVal.val < list.get(destIndex).val) {
                list.set(destIndex + 1, list.get(destIndex));
                destIndex--;
            }
            if (destIndex != i) {
                list.set(destIndex + 1, insertVal);
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        list.get(list.size() - 1).next = null;
        return list.get(0);
    }
}
