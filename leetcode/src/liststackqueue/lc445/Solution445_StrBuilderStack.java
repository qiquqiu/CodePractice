package liststackqueue.lc445;

import liststackqueue.lc23.ListNode;

public class Solution445_StrBuilderStack {
    // 虽然是要按位处理，但还是有一些细节要注意：本题是按照正常的加法的法则
    // 即低位对齐，从低位向高位算，又由于单链表不可逆向的特性，
    // 想要反向遍历必须要反转链表或者使用栈使其反向
    // 这里直接使用栈来实现，当然头插法先反转一遍也可以
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        /*
         * 这里有两个思路：
         * 1.直接使用Stack<Integer>或者Stack<ListNode>，这样的话后续逐位计算的时候就直接
         * 按照该位的值来创建一个节点，然后连接它与上一个节点，从而实现一个结果的链表的逆序链表
         * 最后还要再反转一遍才是结果
         * 2.使用StringBuilder做栈，其内的方法也完全支持作为栈，将每位的结果可以像方法一一样
         * 直接创建节点并且连接，最后反转；也可以仍由字符串形式保存，最后统一倒着遍历一遍构建最终链表
         *
         * 直观地，方法二会比方法一省去不少麻烦，但是内存占用会更高
         * */
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        StringBuilder rt = new StringBuilder();
        while (l1 != null) {
            s1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.append(l2.val);
            l2 = l2.next;
        }
        // s.charAt(s.length() - 1);加上s.deleteCharAt(s.length() - 1)就是栈的pop()方法
        // 注意这里的s.length()不可以提取len替代
        int isNextAdd = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int it1 = s1.charAt(s1.length() - 1) - '0';
            s1.deleteCharAt(s1.length() - 1);
            int it2 = s2.charAt(s2.length() - 1) - '0';
            s2.deleteCharAt(s2.length() - 1);
            if (it1 + it2 + isNextAdd >= 10) {
                rt.append((it1 + it2 + isNextAdd) % 10);
                isNextAdd = 1;
            } else {
                rt.append(it1 + it2 + isNextAdd);
                isNextAdd = 0;
            }
        }

        if (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                int it2 = s2.charAt(s2.length() - 1) - '0';
                s2.deleteCharAt(s2.length() - 1);
                if (it2 + isNextAdd >= 10) {
                    rt.append((it2 + isNextAdd) % 10);
                    isNextAdd = 1;
                } else {
                    rt.append(it2 + isNextAdd);
                    isNextAdd = 0;
                }
            }
        } else /*if (s2.isEmpty())*/ {
            while (!s1.isEmpty()) {
                int it1 = s1.charAt(s1.length() - 1) - '0';
                s1.deleteCharAt(s1.length() - 1);
                if (it1 + isNextAdd >= 10) {
                    rt.append((it1 + isNextAdd) % 10);
                    isNextAdd = 1;
                } else {
                    rt.append(it1 + isNextAdd);
                    isNextAdd = 0;
                }
            }
        }
        // 处理一下最后一位可能遗漏的进位1
        if (isNextAdd != 0) {
            rt.append(isNextAdd);
        }
        ListNode head = null, pre = null;
        for (int i = rt.length() - 1; i >= 0; i--) {
            if (i == rt.length() - 1) {
                pre = new ListNode(rt.charAt(i) - '0');
                head = pre;
            } else {
                pre.next = new ListNode(rt.charAt(i) - '0');
                pre = pre.next;
            }
        }
        return head;
    }
}
