package treerecursion.lc98;

import treerecursion.lc100.TreeNode;

public class Solution98_failed {
    // ***废案，判断的并不全面，不能够实现子树之间的横向比较来判断，比如测试用例中的“3”就是无法错误点***
    // 也就是说判断是BST的时候不能仅考虑左右子节点，而是要考虑左右子树的所有节点，关键是其“定义”！
    // 验证BST（二叉搜索树）
    public boolean isValidBST(TreeNode root) {
        // 基准情况显然是：叶子节点
        if (root.left == null && root.right == null) {
            return true;
        }
        // 否则 （分多条if-else是为了防止空指针）
        if (root.left == null && root.right != null) {
            return root.right.val > root.val && isValidBST(root.right);
        } else if (root.left != null && root.right == null) {
            return root.left.val < root.val && isValidBST(root.left);
        } else {
            return root.left.val < root.val && root.right.val > root.val && isValidBST(root.left)
                    && isValidBST(root.right);
        }
    }
}
