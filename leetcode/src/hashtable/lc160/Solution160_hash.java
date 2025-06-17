package hashtable.lc160;

import liststackqueue.lc23.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution160_hash {
    // HashMap解法实现 O(n) 时间复杂度！
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            // 注意这里面就不要包含head.next == null的情况了，因为这也有可能是重合（指针相等）
            return null;
        }
        // 按照题意，只有指针相同才算重合，不同的节点指针（即地址）不同（即便val相等）
        // 所以显然可以以节点地址为key来存它们的出现次数
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode temp = headA;
        while (temp != null) {
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            // Integer类型，所以不能写 != 0
            if (map.get(temp) != null) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
