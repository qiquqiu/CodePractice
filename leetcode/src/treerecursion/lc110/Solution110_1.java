package treerecursion.lc110;

import treerecursion.lc100.TreeNode;

public class Solution110_1 {
    // 题目：判断二叉树是否平衡
    // 方法一

    // 初步出错：这里在 [1,2,2,3,null,null,3,4,null,null,4] 情况下不通过
    // 修正：还是必须要有两套递归，isBalence内部也要递归来判断
    // 不仅只为当前root节点判断‘一次’，还要为当前节点的左右子节点（树）递归判断
    // 不过这么一来两套递归导致时间复杂度有点高了
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1;
        // 修正：将上面一行改为下面两行
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // 此处作用就是获取以root节点作为根节点的子树的最大深度
    // *注意* 此方法实际上并不是获取指定节点的深度，而是获取指定节点的高度
    // 只不过当我们第一次调用的时候若传参root，则正好是获取树的最大深度
    public int getDepth(TreeNode root) {
        return root == null ? 0 : Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
