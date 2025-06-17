package liststackqueue.lc23;

public class Solution23_1 {
    // 方案1，最简单的暴力法，但是会有超时
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode ans = lists[0];
        // 移用前面“合并2个有序链表”的思路，两两合并，更新答案，向后循环
        for (int i = 1; i < lists.length; i++) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    // 只不过这里“合并2个有序链表”的思路时间复杂度过高（addByVal又有遍历）
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode temp = list1;
        ListNode nextNode = temp.next;
        temp.next = null;
        ListNode newDest = addByVal(temp, list2);
        while (true) {
            temp = nextNode;
            if (temp == null) {
                break;
            } else {
                nextNode = nextNode.next;
            }
            temp.next = null;
            newDest = addByVal(temp, newDest);
        }
        return newDest;
    }

    public ListNode addByVal(ListNode source, ListNode dest) {
        ListNode destHead = new ListNode(0, dest);
        // 将source节点按照顺序添加到以dest为头节点的链表中
        if (dest == null) {
            return dest;
        }
        ListNode temp = destHead;
        while (true) {
            if (temp.next == null) {
                // 此时遍历到了最后一个节点,说明该节点val<=source.val
                temp.next = source;
                break;
            }
            if (temp.next.val > source.val) {
                source.next = temp.next;
                temp.next = source;
                break;
            }
            temp = temp.next;
        }
        return destHead.next;
    }
}