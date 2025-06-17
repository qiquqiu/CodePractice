package treerecursion.lc112;

import treerecursion.lc100.TreeNode;

public class Solution112 {
    // 求是否存在指定路径（从根节点到叶子节点）之和
    int target;
    boolean isExist = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        target = targetSum;
        dfs(root, 0);
        return isExist;
    }

    // 隐式回溯，一遍过0ms
    public void dfs(TreeNode node, int sum) {
        if (node.left == null && node.right == null) {
            if (sum + node.val == target) {
                isExist = true;
                return;
            }
        }

        if (node.left != null) {
            dfs(node.left, sum + node.val);
        }

        // 由于两个if之间并没有return语句并且也不是通过else连接
        // 所以无法包装在当前栈帧（当前节点）的左子树找到了的情况下不再到右子树继续找
        // 所以说在右子树继续找我们需要多加一重限制条件 !isExist
        if (node.right != null && !isExist) {
            dfs(node.right, sum + node.val);
        }
    }
}
