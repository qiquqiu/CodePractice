package liststackqueue.lc23;

public class Solution23_2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode ans = lists[0];
        // 移用前面“合并2个有序链表”的思路，两两合并，更新答案，向后循环
        // 但是显然我感觉可以使用二分来加快
        for (int i = 1; i < lists.length; i++) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    // 优化后的“合并2个有序链表”的思路就是双指针法
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode dumHead = new ListNode(); // 哑节点（虚拟头节点）
        ListNode temp = dumHead;
        ListNode ptr1 = list1;
        ListNode ptr2 = list2;
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val < ptr2.val) {
                temp.next = ptr1;
                if (ptr1 != null) {
                    ptr1 = ptr1.next;
                }
            } else {
                temp.next = ptr2;
                if (ptr2 != null) {
                    ptr2 = ptr2.next;
                }
            }
            temp = temp.next;
        }
        // 跳出while说明有一条链表以及遍历完毕了
        temp.next = ptr1 == null ? ptr2 : ptr1;
        return dumHead.next;
    }
}
