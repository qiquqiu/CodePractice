package treerecursion.lc116;

import java.util.LinkedList;
import java.util.Queue;

public class Solution116_simplified {
    // 本代码也适用于非完全二叉树
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    // 对该行最后一个节点不操作
                    // queue.peek()就是队头走之前时它的下一个
                    node.next = queue.peek();
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}
