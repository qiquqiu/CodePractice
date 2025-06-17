package algorjuniorseries.tree16;

import java.util.ArrayList;

public class Tree16Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */

    /*
     * 实现二叉树的前序、中序和后序遍历，并且将结果保存在一个二维数组
     * 显然，如果将前序、中序和后序遍历的方法写成返回 int[] 的方法
     * 则会非常不利于递归调用，所以直接在外面创建一个集合来供给使用
     * 只需要遍历到节点了就直接add添加即可，无需返回；因为返回了还要考虑
     * 接收等复杂的问题
     *
     * */

    ArrayList<Integer> list = new ArrayList<>();

    public int[][] threeOrders(TreeNode root) {
        int[][] res = new int[3][];
        if (root == null) {
            res[0] = new int[0];
            res[1] = new int[0];
            res[2] = new int[0];
            return res;
        }
        preOrder(root);
        res[0] = list2arr(list);
        list.clear();
        midOrder(root);
        res[1] = list2arr(list);
        list.clear();
        postOrder(root);
        res[2] = list2arr(list);
        return res;
    }

    public void preOrder(TreeNode node) {
        list.add(node.val);
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }

    public void midOrder(TreeNode node) {
        if (node.left != null) {
            midOrder(node.left);
        }
        list.add(node.val);
        if (node.right != null) {
            midOrder(node.right);
        }
    }

    public void postOrder(TreeNode node) {
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }
        list.add(node.val);
    }

    public int[] list2arr(ArrayList<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}