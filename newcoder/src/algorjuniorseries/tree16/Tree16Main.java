package algorjuniorseries.tree16;

import java.util.Arrays;

public class Tree16Main {
    public static void main(String[] args) {
        Tree16Solution t16solu = new Tree16Solution();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        int[][] res = t16solu.threeOrders(root);
        System.out.println("前序" + Arrays.toString(res[0]));
        System.out.println("中序" + Arrays.toString(res[1]));
        System.out.println("后序" + Arrays.toString(res[2]));
    }
}
