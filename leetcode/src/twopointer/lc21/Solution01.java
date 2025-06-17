package twopointer.lc21;

class Solution01 {
    public ListNode01 mergeTwoLists(ListNode01 list1, ListNode01 list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode01 temp = list1;
        ListNode01 nextNode = temp.next;
        temp.next = null;
        ListNode01 newDest = addByVal(temp, list2);
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

    public ListNode01 addByVal(ListNode01 source, ListNode01 dest) {
        ListNode01 destHead = new ListNode01(0, dest);
        // 将source节点按照顺序添加到以dest为头节点的链表中
        if (dest == null) {
            return dest;
        }
        ListNode01 temp = destHead;
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