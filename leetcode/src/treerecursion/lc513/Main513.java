package treerecursion.lc513;

import treerecursion.lc100.TreeNode;

public class Main513 {
    // 显然我们最直观的思路就是使用层序遍历
    // 最难的思路就是递归与回溯
    public static void main(String[] args) {
        Solution513_ErrorDraft solution513Draft = new Solution513_ErrorDraft();
        Solution513_LevelOrder solution513_levelOrder = new Solution513_LevelOrder();
        Solution513_recursion_backdate solution513_recursion_backdate = new Solution513_recursion_backdate();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        root.left.right.left = new TreeNode(10);
        root.right.left.right = new TreeNode(111);

//        int bottomLeftValue = solution513Draft.findBottomLeftValue(root);
//        System.out.println(bottomLeftValue);

//        int bottomLeftValue = solution513_levelOrder.findBottomLeftValue(root);
//        System.out.println(bottomLeftValue);

        int bottomLeftValue = solution513_recursion_backdate.findBottomLeftValue(root);
        System.out.println(bottomLeftValue);
    }
}
