package treerecursion.lc257;

import treerecursion.lc100.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution257_2 {
    List<String> res;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        constructPaths(root, "");
        return res;
    }

    // 设置参数为基本数据类型（String不可变，可以这么认为）
    // 这里仅作与另一方法对比，实际效率并不高
    private void constructPaths(TreeNode node, String path) {
        if (node.left == null && node.right == null) { // 叶子节点
            res.add(path + node.val);
            return;
        }
        if (node.left != null) { // 左子树不为空
            constructPaths(node.left, path + node.val + "->");
        }
        if (node.right != null) { // 右子树不为空
            constructPaths(node.right, path + node.val + "->");
        }
    }
}
