package liststackqueue.lc234;

import liststackqueue.lc23.ListNode;

public class Solution234_tp {
    // 首先，由于这是单链表的回文序列题目，所以说总体上只有一种思路，就是遍历获取前半段和后半段序列
    // 然后拿一段逆转和另一段比较是否相等，而不能像数组那样从两端开始遍历；还有一个类似的思路，就是把
    // 整个链表全部反转过来（头插法O(n)），重新遍历比较

    // 之所以想到可以使用双指针之快慢指针，因为题目涉及到了“回文”
    // 也就意味着要找到“中间，一半”的位置，而使用快慢指针显然由有一个是vt，一个是2vt，且2vt=len
    // 即vt=len/2，所以快慢指针可以在一次O(n)循环中就找到一半的位置（中间处要根据奇偶处理些细节）
    // 如果采用简单思路先遍历O(n)获取len，再遍历存序列当然也可以，只不过要多一遍遍历
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        boolean isEvenLen = false;
        while (fast.next != null) {
            sb1.append(slow.val);
            slow = slow.next;
            if (fast.next.next != null) {
                fast = fast.next.next;
            } else {
                // 长度为偶数的情况的最后一步
                fast = fast.next;
                isEvenLen = true;
            }
        }
        // 如果是奇数长度，让slow从当前的下一个开始再记录序列
        // 因为如果是回文，那么以中间节点为分割，不含中间节点也应是回文
        if (!isEvenLen) {
            slow = slow.next;
            while (slow != null) {
                sb2.append(slow.val);
                slow = slow.next;
            }
        } else {
            // 如果是偶数长度，让slow从当前开始再记录序列
            while (slow != null) {
                sb2.append(slow.val);
                slow = slow.next;
            }
        }
        // 这里调用StringBuilder的方法可能导致时间提高
        return sb1.reverse().toString().contentEquals(sb2);
    }
}
