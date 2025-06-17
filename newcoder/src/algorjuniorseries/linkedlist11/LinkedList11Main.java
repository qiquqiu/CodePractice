package algorjuniorseries.linkedlist11;

public class LinkedList11Main {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        node1.next = node3;
        node3.next = node5;

        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        node2.next = node4;
        node4.next = node6;

        // 合并[1, 3, 5]链表和[2, 4, 6]链表
        ListNode merged = mergeByRecursion(node1, node2);

        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }

    /**
     * 使用递归实现“合并两个有序的链表为一个链表”
     * 这里传入的头节点默认都是带值的
     *
     * @param pHead1 第一个链表的头节点
     * @param pHead2 第二个链表的头节点
     * @return 合并后的有序链表的头节点
     */
    public static ListNode mergeByRecursion(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null) {
            return pHead2;
        }
        if (pHead2 == null) {
            return pHead1;
        }
        ListNode newHead;
        if (pHead1.val < pHead2.val) {
            newHead = pHead1;
            newHead.next = mergeByRecursion(pHead1.next, pHead2);
        } else {
            newHead = pHead2;
            newHead.next = mergeByRecursion(pHead1, pHead2.next);
        }
        return newHead;
    }

    // 方法二：使用普通的方法，即遍历链表一，依次取出所有节点，按照addByOrder方法来添加
}

/*
 * 合并两个链表
 *
 * */

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}