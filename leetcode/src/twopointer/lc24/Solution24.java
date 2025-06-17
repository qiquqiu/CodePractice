package twopointer.lc24;

public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            // 通过短路与判断只有0个或者1个节点的情况
            // head==null的条件判断式一定要写在前面
            return head;
        }
        // head不为null的情况
        ListNode mhead = new ListNode(0); // 虚拟头节点
        ListNode pre = mhead;
        ListNode left = head;
        ListNode right = left.next;
        // 但凡这两个指针有一个指向空节点就到了结束
        while (left != null && right != null) {
            left.next = right.next;
            right.next = left;
            pre.next = right;

            pre = left;
            left = left.next;
            // 之所以if判断是因为left.next无法保证非空
            if (left != null) {
                right = left.next;
            }
        }
        return mhead.next;
    }
}
