package treerecursion.lc700;

import treerecursion.lc100.TreeNode;

public class Solution700 {
    // 注意：在标准的二叉搜索树（BST）定义中，通常不允许有值重复的节点
    // 0ms，递归一把过
    public TreeNode searchBST(TreeNode root, int val) {
        // 这个函数的关键不是在于向左右去递归的操作
        // 关键在于如何处理“没找到就返回空”这里的“没找到”
        // 注意，这里的“没找到”是指在当前节点的左右子树递归中‘均’未找到才算！
        if (root == null) {
            return null;
        }
        TreeNode leftRet = null;
        TreeNode rightRet = null;
        if (root.val == val) {
            return root;
        } else if (val <= root.val) {
            leftRet = searchBST(root.left, val);
        } else {
            leftRet = searchBST(root.right, val);
        }
        return (leftRet == null && rightRet == null) ? null : (leftRet == null ? rightRet : leftRet);
    }
}
