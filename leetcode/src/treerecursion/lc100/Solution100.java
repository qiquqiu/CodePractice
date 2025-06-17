package treerecursion.lc100;

public class Solution100 {
    // 第一个思路就是暴力，因为我们知道知道了前中（或中后）序遍历就可以唯一确定一个树
    // 所以我们可以分别对二者进行前序和中序遍历，然后分别比较遍历结果（如用字符串记录）
    // 第二个思路就是我们不用等到结果时候比较，直接在每次遍历的时候比较（有树首先考虑递归思想）
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameNode(p, q);
    }

    public boolean isSameNode(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == null && q == null;
        }
        if (p.val == q.val) {
            return isSameNode(p.left, q.left) && isSameNode(p.right, q.right);
        }
        return false;
    }
}