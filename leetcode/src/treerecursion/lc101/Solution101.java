package treerecursion.lc101;

import treerecursion.lc100.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Solution101 {
    // emm此方法不行！因为树的结构也是重要的，而此方法只能判断满二叉树
    public boolean isSymmetric(TreeNode root) {
        // 由题意root不会为null
        ArrayList<String> res1 = levelOrder(root.left, 0);
        ArrayList<String> res2 = levelOrder(root.right, 1);
        int size1 = res1.size();
        int size2 = res2.size();
        if (size1 != size2) {
            return false;
        } else {
            for (int i = 0; i < size1; i++) {
                if (!res1.get(i).equals(res2.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    public ArrayList<String> levelOrder(TreeNode node, int way) {
        ArrayList<String> strings = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if (node == null) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int levelLen = queue.size();
            // 以下for循环就代表每层遍历
            for (int i = 0; i < levelLen; i++) {
                TreeNode curNode = queue.poll();

                sb.append(curNode.val);

                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            // 0代表左子树，1代表右子树
            if (way == 1) {
                strings.add(sb.reverse().toString());
            } else {
                strings.add(sb.toString());
            }
            sb.setLength(0);
        }
        return strings;
    }
}
