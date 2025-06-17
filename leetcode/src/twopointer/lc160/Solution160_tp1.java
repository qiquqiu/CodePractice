package twopointer.lc160;

import liststackqueue.lc23.ListNode;

public class Solution160_tp1 {
    // 双指针解法1（最直观的双指针）
    // 一样思路的题解：https://leetcode.cn/problems/intersection-of-two-linked-lists/description/comments/1632432
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode ptrA = headA, ptrB = headB;
        int lenA = 0, lenB = 0;
        while (ptrA != null) {
            lenA++;
            ptrA = ptrA.next;
        }
        while (ptrB != null) {
            lenB++;
            ptrB = ptrB.next;
        }
        ptrA = headA;
        ptrB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                ptrA = ptrA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                ptrB = ptrB.next;
            }
        }
        while (ptrA != null) {
            if (ptrA == ptrB) {
                return ptrA;
            }
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        return null;
    }
}
