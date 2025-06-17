package treerecursion.lc572;

import treerecursion.lc100.TreeNode;

public class Solution572 {
    // 由题目验证得知，当目标树和sub树为相同树的时候，也是返回true
    // 这里是有一个“交错递归”的实现的，两种递归都是使用的dfs，当然，isSameTree也可以用层序遍历bfs做
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isSameTree(root.left, subRoot) || isSameTree(root.right, subRoot) || isSameTree(root, subRoot)) {
            return true;
        } else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    public boolean isSameTree(TreeNode r1, TreeNode r2) {
        if ((r1 == null && r2 != null) || (r1 != null && r2 == null)) {
            return false;
        } else if (r1 == null && r2 == null) {
            return true;
        } else {
            // 原来是这里r1，r2均非空时少了个判断条件导致的错误
            return r1.val == r2.val && isSameTree(r1.left, r2.left) && isSameTree(r1.right, r2.right);
        }
    }
}
