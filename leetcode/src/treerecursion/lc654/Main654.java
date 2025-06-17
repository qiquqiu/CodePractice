package treerecursion.lc654;

import treerecursion.lc100.TreeNode;

public class Main654 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(6);
//        TreeNode left1 = new TreeNode(3);
//        TreeNode right1 = new TreeNode(5);
//        root.left = left1;
//        root.right = right1;
//        left1.right = new TreeNode(2);
//        left1.right.right = new TreeNode(1);
//        right1.left = new TreeNode(0); // 弄错了
        Solution654 solution654 = new Solution654();

        int[] nums = {3, 2, 1, 6, 0, 5};

        TreeNode treeRoot = solution654.constructMaximumBinaryTree(nums);

        System.out.println(treeRoot.val);
    }
}
