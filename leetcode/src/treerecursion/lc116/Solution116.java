package treerecursion.lc116;

import java.util.LinkedList;
import java.util.Queue;

public class Solution116 {
    // 以下此法固然是写麻烦了，实际上如果还是用层序遍历的思路
    // 也可以用一个队列来实现，此时需要用到Queue中的方法：offer，将数据添加到队尾
    // 这相当于一种循环复用此队列


    // 填充每个节点的下一个右侧节点指针
    // 注意题目有一点说明：在开始的时候，所有的节点的next默认初始都为null
    // 所以每一列的最后一个节点不用显示地将其next设置为null
    // 所以此方法最后不用做：pre不为null时候进行pre.next=null
    public Node connect(Node root) {
        // 初步思路还是层序遍历，不过是使用两个队列
        if (root == null) {
            return null;
        }
        Queue<Node> que1 = new LinkedList<>();
        Queue<Node> que2 = new LinkedList<>();

        que1.add(root);

        while (!que1.isEmpty() || !que2.isEmpty()) {
            int size = getSize(que1, que2);
            Node pre = null, node1, node2;

            if (que2.isEmpty()) {
                addLeftRight(que1.peek(), que2);
                while (!que1.isEmpty()) {
                    if (pre == null) {
                        node1 = que1.poll();
                    } else {
                        node1 = pre;
                    }
                    node2 = que1.isEmpty() ? null : que1.poll();
                    addLeftRight(node2, que2);
                    node1.next = node2;
                    pre = node2;
                }
            } else {
                addLeftRight(que2.peek(), que1);
                while (!que2.isEmpty()) {
                    if (pre == null) {
                        node1 = que2.poll();
                    } else {
                        node1 = pre;
                    }
                    node2 = que2.isEmpty() ? null : que2.poll();
                    addLeftRight(node2, que1);
                    node1.next = node2;
                    pre = node2;
                }
            }
        }
        return root;
    }

    // 获取非空的队列的长度
    public int getSize(Queue<Node> queue1, Queue<Node> queue2) {
        return queue1.isEmpty() ? queue2.size() : queue1.size();
    }

    // 判断当前节点的左右节点是否为空，若非空则加入另一队列
    public void addLeftRight(Node root, Queue<Node> que) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            que.add(root.left);
        }
        if (root.right != null) {
            que.add(root.right);
        }
    }
}
