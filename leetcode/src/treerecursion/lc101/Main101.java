package treerecursion.lc101;

import treerecursion.lc100.TreeNode;

public class Main101 {
    public static void main(String[] args) {
//        Solution101 solution101 = new Solution101();
        TreeNode root = new TreeNode(0, new TreeNode(2), new TreeNode(3));
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(3);

//        boolean symmetric = solution101.isSymmetric(root);
//        System.out.println("The tree is symmetric: " + symmetric);


        Solution101_2 solution101_2 = new Solution101_2();
        System.out.println(solution101_2.isSymmetric(root));
    }
}
