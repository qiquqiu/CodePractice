package treerecursion.lc257;

import treerecursion.lc100.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {
    // 与走迷宫问题一样都是找路径，都要用回溯!（相关题目：lc112、lc113）
    // 回溯：最复杂的递归！
    List<String> res;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<String> path = new ArrayList<>();
        getPath(root, path);
        return res;
    }

    /**
     * @param node     本地递归的父节点
     * @param lastPath 截止到父节点的路径值
     */
    public void getPath(TreeNode node, List<String> lastPath) {
//        if (node == null) {
//            System.out.println("node 为null");
//            // 这一块if不需要
//            return;
//        }
        lastPath.add(node.val + "->");
        if (node.left == null && node.right == null) {
            String lastUnit = lastPath.removeLast();
            String dealUnit = lastUnit.substring(0, lastUnit.length() - 2);
            lastPath.add(dealUnit);
            res.add(list2String(lastPath));
        }

        if (node.left != null) {
            getPath(node.left, lastPath);
//            回溯要和递归永远在一起
            lastPath.removeLast();
        }

        if (node.right != null) {
            getPath(node.right, lastPath);
            lastPath.removeLast();
        }
    }

    public String list2String(List<String> path) {
        StringBuilder sb = new StringBuilder();
        for (String s : path) {
            sb.append(s);
        }
        return sb.toString();
    }
}