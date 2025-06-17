package treerecursion.lc513;

import treerecursion.lc100.TreeNode;

public class Solution513_recursion_backdate {
    int depthest = -1;
    int resVal = 0;

    // 真是很有难度的回溯 相当于dfs
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return resVal;
    }

    // 成了，0ms一遍过（受Carl文章一点启发）
    // 这里的回溯点在于“depth”
    public void dfs(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            // 如果到某一次depth == depthest时候（显然不是第一次）
            // 我们绝对不能更新，因为整体的方向是左优先，右次之
            // 所以说当depth == depthest的时候，此时的node即为与
            // 之前的以及保持了depthest的节点在同一层，并且必位于其右边
            if (depth > depthest) {
                depthest = depth;
                resVal = node.val;
            }
            return; // return使不再进行多余的两个if判断
        }
        // 优先遍历左子树，一定要总是优先左！！！
        if (node.left != null) {
            dfs(node.left, depth + 1);
        }

        // 再遍历右子树
        if (node.right != null) {
            dfs(node.right, depth + 1);
        }
    }
}

/* Carl:
 * 咋眼一看，这道题目用递归的话就就一直向左遍历，最后一个就是答案呗？
 * 没有这么简单，一直向左遍历到最后一个，它未必是最后一行啊。
 * 我们来分析一下题目：在树的最后一行找到最左边的值。
 * 首先要是最后一行，然后是最左边的值。
 * 如果使用递归法，如何判断是最后一行呢，其实就是深度最大的叶子节点一定是最后一行。
 * 如果对二叉树深度和高度还有点疑惑的话，请看：110.平衡二叉树 (opens new window)。
 * 所以要找深度最大的叶子节点。
 * 那么如何找最左边的呢？可以使用前序遍历（当然中序，后序都可以，因为本题没有中间节点的处理逻辑，只要左优先就行）
 * 保证优先左边搜索，然后记录深度最大的叶子节点，此时就是树的最后一行最左边的值。
 * */

// 想要实现判断是最深的节点，无需单独再写一个递归的求深度的方法；只需要把每个节点的深度作为一个参数depth
// 在递归中传递，每向左右递归的时候就‘在递归传参处加1’，从而还能够完整的保存当前栈帧的depth值（当前节点
// 的depth），从而保证了向下遇到叶子节点之后再‘回溯’到该节点的时候，能有该节点的depth值！