package algorjuniorseries.linkedlist10;

public class LinkedList10Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode reversed = reverseList(head);

        while (reversed != null) {
            System.out.println(reversed.val);
            reversed = reversed.next;
        }
    }

    /*
    * “头插法” 温故：画图最好理解，利用双指针，cur与nex;也要利用辅助空头节点
    * Line38如果紧接着在Line34后面写的化就还需要一个if判断
    * 而如果在判断break之后写的话就不需要了（都是为了处理最后一次的情况）
    * */

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode reverseHead = new ListNode(0);
        ListNode cur = head;
        ListNode nex = cur.next;
        while (true) {
            cur.next = reverseHead.next;
            reverseHead.next = cur;

            cur = nex;
            if (cur == null) {
                break;
            }
            nex = nex.next;
        }
        return reverseHead.next;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
