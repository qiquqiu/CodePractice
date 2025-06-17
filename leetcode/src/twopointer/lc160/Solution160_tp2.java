package twopointer.lc160;

import liststackqueue.lc23.ListNode;

public class Solution160_tp2 {
    // 最妙的双指针！
    // 本思路来源：https://leetcode.cn/problems/intersection-of-two-linked-lists/description/comments/3107
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode ptrA = headA, ptrB = headB;
        while (ptrA != ptrB) {
            /*
            * 赏析：
            * 1.如果有相交（默认长度不等），那么第一轮短的链表的指针A到达末尾时候与长的链表的指针的距离必为初始
            *   距离d（领先长链表的指针d），此时让A指针下一步移到长链表头节点headB上，是其步骤放慢d（显然第一轮
            *   不可能相遇，此时二者相位差就是0，下一轮必然会同时到达开始相交处）
            *   妙就妙在通过到达末尾之后的交换重新指向的头节点这一微小操作实现了Solution160_tp1中一直到Line32.之前的作用
            * 2.如果无相交，那么同理的，第二轮之后二者相位差总是0，那么将在末尾null==null退出while
            * */
            ptrA = ptrA == null ? headB : ptrA.next;
            ptrB = ptrB == null ? headA : ptrB.next;
        }
        return ptrA;
    }
}
