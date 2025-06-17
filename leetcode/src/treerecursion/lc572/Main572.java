package treerecursion.lc572;

import treerecursion.lc100.TreeNode;

public class Main572 {
    public static void main(String[] args) {
        Solution572 solution572 = new Solution572();

        TreeNode root = new TreeNode(1);
        TreeNode sub = new TreeNode(0);

        boolean ret = solution572.isSubtree(root, sub);

        System.out.println(ret);
    }
}
