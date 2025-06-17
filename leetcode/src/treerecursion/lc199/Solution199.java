package treerecursion.lc199;

import treerecursion.lc100.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution199 {
    // 二叉树的右视图
    // 这道题和层序遍历、层序遍历逆转从层底开始等等十题都是一个思路
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return res;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            // 遍历一层
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (i == len - 1) {
                        // 只需要按照层序遍历
                        // 并且只添加最右边的就可以了
                        res.add(node.val);
                    }

                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
        }
        return res;
    }
}
