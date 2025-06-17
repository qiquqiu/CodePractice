package treerecursion.lc112;

import treerecursion.lc100.TreeNode;

public class Main112 {
    // 与lc257很相似
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);

        root.right.left.right = new TreeNode(12);

        Solution112 solution112 = new Solution112();
        int target = 22;
        boolean isExist = solution112.hasPathSum(root, target);
        System.out.println(isExist);
    }
}
