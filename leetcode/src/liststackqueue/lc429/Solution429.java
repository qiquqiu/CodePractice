package liststackqueue.lc429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution429 {
    // 多叉树的层序遍历，与二叉树的层序遍历思路类似的
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        List<Integer> level; // 存放每一层结果的集合

        queue.add(root);

        while (!queue.isEmpty()) {
            level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll(); // 这里node不会为null
                level.add(node.val);
                // 接下来就是对本节点的子节点列表的依次遍历添加
                for (Node child : node.children) {
                    if (child != null) {
                        queue.add(child);
                    }
                }
            }
            res.add(level);
        }
        return res;
    }
}
