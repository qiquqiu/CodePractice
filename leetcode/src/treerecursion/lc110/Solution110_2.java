package treerecursion.lc110;

import treerecursion.lc100.TreeNode;

public class Solution110_2 {
    // 方法二
    public boolean isBalanced(TreeNode root) {
        // root为null的情况也包含在里面返回非-1了
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            // 由叶子节点递归进来的，其子树长度返回0
            return 0;
        }

        // 先获取左右子树高度，我们后面人为的将已将确定不是平衡二叉树的子树高度记为-1
        // 这两个地方获取高度时如果是-1则直接返回给调用者，从而一直向上返回回溯了（就结束了）
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        // 这里相当于是一种后序遍历，因为先获取到了左右子树高度
        if (Math.abs(leftHeight - rightHeight) > 1) {
            // 当前节点的左子树和右子树的高度差大于1，则当前节点所引出的子树
            // 已经确定非平衡二叉树，即刻返回-1到父节点...
            return -1;
        } else {
            // 否则父节点的高度就是Max(左子树高度，右子树高度) + 1（本节点）
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
