package unclassified.lc02;

public class LinkedList01 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9)))))));
        ListNode l2 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))));
        Solution solution = new Solution();
        ListNode l3 = solution.addTwoNumbers(l1, l2);
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode() {

    }

    ListNode(int val, ListNode node) {
        this.val = val;
        this.next = node;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode head = l3;
        boolean flag = false;
        boolean l1_null = false;
        boolean l2_null = false;
        while (true) {
            if (!l1_null && !l2_null) {
                l3.val = (l1.val + l2.val + (flag ? 1 : 0)) % 10;
                flag = l1.val + l2.val + (flag ? 1 : 0) >= 10;
            } else if (l1_null && !l2_null) {
                l3.val = (l2.val + (flag ? 1 : 0)) % 10;
                flag = (l2.val + (flag ? 1 : 0)) >= 10;
            } else if (l2_null && !l1_null) {
                l3.val = (l1.val + (flag ? 1 : 0)) % 10;
                flag = (l1.val + (flag ? 1 : 0)) >= 10;;
            }

            if (l1.next == null) {
                l1_null = true;
            } else {
                l1 = l1.next;
            }
            if (l2.next == null) {
                l2_null = true;
            } else {
                l2 = l2.next;
            }

            if (!l1_null || !l2_null) {
                l3.next = new ListNode();
                l3 = l3.next;
            } else {
                lastForward(l3, flag);
                break;
            }
        }
        return head;
    }

    public void lastForward(ListNode node, boolean flag) {
        if (flag) {
            node.next = new ListNode(1);
        }
    }
}
