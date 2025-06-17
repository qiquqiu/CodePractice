package treerecursion.lc101;

import treerecursion.lc100.TreeNode;

public class Solution101_2 {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        // 基准情况（3种）
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            // 由于是else-if，所以能进入此处
            // 必定说明“left与right只有1个为null”
            return false;
        } else if (left.val != right.val) {
            return false;
        }

        // 递归调用
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
