package treerecursion.lc116;

public class Solution116_recursion {
    // 递归实现的版本，递归的思路与lc101很神似，有点难度，见左侧图解
    // 都是将问题，化为两个较大次小问题，再继续重复这个过程，直到最小单元“left <- root -> right”
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        bfs(root.left, root.right);
        return root;
    }

    // bfs:广度优先搜索，left：传入左节点、right：传入右节点
    // 由于题目给我们的是：完全二叉树，所以说除了叶子节点，其他节点的left以及right都无需做非空判断
    public static void bfs(Node left, Node right) {
        if (left == null && right == null) {
            // 退出（不再继续向下递归）条件：遇到了叶子节点就返回
            return;
        }
        left.next = right;
        // 一直到这一步，当前bfs的基本作用就是将单元“left <- root -> right”
        // （这里的left和right可以是单节点也可以是子树）的left的next指向right

        // 开始向其他部分递归调用

        // 对传入的左节点所引出的子树进行递归
        // 实现左节点所引出的子树的全部 左.next = 右
        bfs(left.left, left.right);

        // 对不为与一个“left <- root -> right”结构上的
        // 但是相邻的右、左节点进行连接
        bfs(left.right, right.left);

        // 对传入的右节点所引出的子树进行递归
        // 实现右节点所引出的子树的全部 右.next = 左
        bfs(right.left, right.right);
    }
}
