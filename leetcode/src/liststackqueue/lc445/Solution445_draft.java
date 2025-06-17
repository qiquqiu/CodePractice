package liststackqueue.lc445;

import liststackqueue.lc23.ListNode;

// 两数相加Ⅱ（和两数相加Ⅰ解法类似）
public class Solution445_draft {
    // 两个思路：一个就是反转链表，再按照逐位相加以及进位逻辑构建结果链表
    // 另一个思路就是直接分别转化为数字，相加再将结果转化为链表
    // 不过第一个思路同样的存在和第一个版本的题目一样的问题，即int越界
    // 所以说不能够直接相加，由于链表长度就是数的位数，可以很长，所以要按位处理
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode temp = l1;
        StringBuilder sb = new StringBuilder();
        int val1 = 0, val2 = 0;
        while (temp != null) {
            sb.append(temp.val);
            temp = temp.next;
        }
        val1 = Integer.parseInt(sb.toString());
        temp = l2;
        sb.setLength(0);
        while (temp != null) {
            sb.append(temp.val);
            temp = temp.next;
        }
        val2 = Integer.parseInt(sb.toString());
        sb.setLength(0);
        sb.append(val1 + val2);
        ListNode pre = null, head = null;
        for (int i = 0; i < sb.length(); i++) {
            if (pre == null) {
                pre = new ListNode(sb.charAt(i) - '0');
                head = pre;
            } else {
                pre.next = new ListNode(sb.charAt(i) - '0');
                pre = pre.next;
            }
        }
        return head;
    }
}
