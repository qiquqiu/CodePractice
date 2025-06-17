package treerecursion.lc98;

import treerecursion.lc100.TreeNode;

public class Main98 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

//        Solution98_failed solution98 = new Solution98_failed();
//        boolean validBST = solution98.isValidBST(root);
//        System.out.println(validBST);

        Solution98_correct solution98Correct = new Solution98_correct();
        boolean validBST = solution98Correct.isValidBST(root);
        System.out.println(validBST);
    }
}
