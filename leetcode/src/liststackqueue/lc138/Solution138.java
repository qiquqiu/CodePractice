package liststackqueue.lc138;

import java.util.HashMap;
import java.util.Map;

public class Solution138 {
    // 理解此题链表的深拷贝：拷贝完节点（通过new Node）以及next关系就完成了一半
    public Node copyRandomList(Node head) {
        Node dumHead = new Node(0);
        Node p = head, q = dumHead;
        Map<Node, Node> map = new HashMap<>();

        // 第一次遍历链表，复制节点值并建立新旧节点的映射
        // 原链表节点做键，新链表节点做值
        while (p != null) {
            q.next = new Node(p.val);
            q = q.next;
            map.put(p, q);
            p = p.next;
        }

        // 第二次遍历链表，根据map处理 random 指针
        p = head;
        q = dumHead.next;
        // p是原链表节点，q是新链表节点
        while (p != null) {
            if (p.random != null) {
                // p和q在位置上是一一对应的关系
                q.random = map.get(p.random);
            }
            p = p.next;
            q = q.next;
        }

        return dumHead.next;
    }

/*    public Node copyNode(Node priNode) {
        if (priNode == null) {
            return null;
        }
        Node ret = new Node(priNode.val);
        ret.next = copyNode(priNode.next);
        ret.random = copyNode(priNode.random);
        return ret;
        // 不能使用递归！！！会出现循环，即死递归！！！
    }*/
}
