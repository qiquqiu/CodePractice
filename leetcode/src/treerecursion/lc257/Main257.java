package treerecursion.lc257;

import treerecursion.lc100.TreeNode;

import java.util.List;

public class Main257 {
    public static void main(String[] args) {
        Solution257 solution257 = new Solution257();
        Solution257_2 solution257_2 = new Solution257_2();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(8);

        List<String> paths = solution257.binaryTreePaths(root); // 方法一
//        List<String> paths = solution257_2.binaryTreePaths(root); // 方法二

        System.out.println(paths);
    }
}
