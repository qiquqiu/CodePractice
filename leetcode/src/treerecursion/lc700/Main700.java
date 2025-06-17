package treerecursion.lc700;

import treerecursion.lc100.TreeNode;

public class Main700 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        Solution700 solution700 = new Solution700();
        TreeNode searchBST = solution700.searchBST(root, 5);
        System.out.println(searchBST == null ? null : searchBST.val);
    }
}
