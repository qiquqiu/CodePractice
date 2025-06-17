package treerecursion.lc106;

import treerecursion.lc100.TreeNode;

public class Main106 {
    public static void main(String[] args) {
        Solution106 solution106 = new Solution106();
        Solution106_simplified01 solution106_simp = new Solution106_simplified01();
//        int[] inorder = {9, 3, 15, 20, 7};
//        int[] postorder = {9, 15, 7, 20, 3};

        int[] inorder = {1, 2, 3, 4};
        int[] postorder = {2, 1, 4, 3};

//        TreeNode treeRoot = solution106.buildTree(inorder, postorder);
//        System.out.println(treeRoot.val);

        TreeNode root = solution106_simp.buildTree(inorder, postorder);
        System.out.println(root.val);
    }
}
