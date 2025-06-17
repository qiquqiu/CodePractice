package treerecursion.lc102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import treerecursion.lc100.TreeNode;

public class Solution102 {
    // 二叉树的层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // 主要用增删操作，所以我们选链表实现的队列
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> level;

        queue.add(root);

        while (!queue.isEmpty()) {
            level = new ArrayList<>();
            int len = queue.size();
            // 遍历一层
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    level.add(node.val);

                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            res.add(level);
        }
        return res;
    }
}