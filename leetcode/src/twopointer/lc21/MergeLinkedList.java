package twopointer.lc21;

public class MergeLinkedList {
    public static void main(String[] args) {
        ListNode01 l1 = new ListNode01(1);
        ListNode01 l2 = new ListNode01(2);
        Solution01 solution01 = new Solution01();
        ListNode01 listNode01 = solution01.mergeTwoLists(l1, l2);
        while (listNode01 != null) {
            System.out.println(listNode01.val);
            listNode01 = listNode01.next;
        }
    }
}