package liststackqueue.lc147;

import liststackqueue.lc23.ListNode;

// 思路链接：https://leetcode.cn/problems/insertion-sort-list/description/comments/1870022
//         https://leetcode.cn/problems/insertion-sort-list/description/comments/1956212
public class Solution147_twopointer {
    // 双指针法（三指针）实现对单链表进行插入排序,时间复杂度为O(n)
    // 思考思路来源：由于观察动画不难发现，插入排序与链表的反转有相似之处（仅仅只是代码有点像，原理完全不一样）
    // 区别就在于“头”的位置不一样，此处的“头”只是大小关系合理的位置，所以说这个并不会导致链表反转
    // 这也是头插法是O(n)而此法是O(n^2)的原因，多的地方就在在于“找大小关系合理的位置”处的循环
    // 一旦一个元素排好序之后，那么他所在的有序表显然无法再改变相对位置了，这点与链表反转的辅助链表特点一致
    // 插入排序中的“有序表”可以理解为挂在reverseHead上面的节点，而“无需表”就是剩下的节点
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode temp = head;
        while (temp != null) {
            // 当前要操作（排序对象）是原链表中的temp
            ListNode nxt = temp.next; // 先保存原链表
            ListNode cur = dummy;
            // 此处的细节，从辅助头节点开始遍历，但是比较的时候要用cur.next.val来比，
            // 因为如果最后是因为后面这句而退出的while循环，那么后续将还会用上cur指针
            // 所以说不能通过cur.val来比，这样会导致此原因退出循环的时候cur不能指向紧接着比temp.val小的位置
            while (cur.next != null && cur.next.val < temp.val) {
                cur = cur.next;
            }
            // 这里就是头插法反转链表的代码，只不过这里的“头”是移动的，不必是第一个虚拟头
            temp.next = cur.next;
            cur.next = temp;
            temp = nxt;
        }
        return dummy.next;
    }
}