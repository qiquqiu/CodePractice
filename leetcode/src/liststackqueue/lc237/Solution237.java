package liststackqueue.lc237;

import liststackqueue.lc23.ListNode;

public class Solution237 {
    // “删除”链表中的节点，参数是仅仅知道要删除的节点；
    // 反常题，但是细看题目提示此“删除”彼“删除”

    // 注意，删除节点并不是指从内存中删除它。这里的意思是：
    // 给定节点的值不应该存在于链表中。
    // 链表中的节点数应该减少 1。
    // node 前面的所有值顺序相同。
    // node 后面的所有值顺序相同。
    public void deleteNode(ListNode node) {
        ListNode temp = node;
        // 知道倒数第二个节点停止
        while (temp.next.next != null) {
            temp.val = temp.next.val;
            temp = temp.next;
        }
        temp.val = temp.next.val;
        temp.next = null;
    }
}
