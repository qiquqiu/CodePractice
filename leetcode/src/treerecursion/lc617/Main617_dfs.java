package treerecursion.lc617;

import treerecursion.lc100.TreeNode;

public class Main617_dfs {
    public static void main(String[] args) {
        Solution617_dfs_recursion s1 = new Solution617_dfs_recursion();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        TreeNode retRoot = s1.mergeTrees(root1, root2);

        System.out.println(retRoot.val);
    }
}
