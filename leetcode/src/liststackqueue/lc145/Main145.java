package liststackqueue.lc145;

import treerecursion.lc100.TreeNode;

import java.util.List;

public class Main145 {
    public static void main(String[] args) {
        Solution145 s145 = new Solution145();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2, new TreeNode(3), null);
        List<Integer> list = s145.postorderTraversal(root);
        System.out.println("list = " + list);
    }
}
