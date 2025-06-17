package liststackqueue.lc445;

import liststackqueue.lc23.ListNode;

public class Main445 {
    public static void main(String[] args) {
//        Solution445_draft s445dr = new Solution445_draft();
        Solution445_StrBuilderStack s445 = new Solution445_StrBuilderStack();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9, new ListNode(9));
        ListNode sumHead = s445.addTwoNumbers(l1, l2);
        while (sumHead != null) {
            System.out.print(sumHead.val);
            sumHead = sumHead.next;
        }
    }
}
