package treerecursion.lc114;

import treerecursion.lc100.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
        list.getLast().left = null;
        list.getLast().right = null;
    }

    // 这里的前序遍历也可以使用栈做非递归实现
    public void preOrder(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        list.add(node);
        if (node.left != null) {
            preOrder(node.left, list);
        }
        if (node.right != null) {
            preOrder(node.right, list);
        }
    }
}
