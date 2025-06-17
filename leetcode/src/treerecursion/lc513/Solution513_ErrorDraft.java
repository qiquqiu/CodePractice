package treerecursion.lc513;

import treerecursion.lc100.TreeNode;

public class Solution513_ErrorDraft {
    // 初步实现是这样子的，但是是有问题的
    // 我们不能用lefth来判断谁在更左边，这是错的
    // 比如这个例子：（到leetcode用例里面输入就可以查看图形了）
    // [ 50, 25, 75, 2, null, 55, null, null, 5, null, 59, 4, 6, 58, null, null, null, null, 7, 57, null ]
    int depthest = -1;
    int lefthest = -1;
    int resVal = 0;

    // emm我的思路是，通过递归找到所有的叶子节点，保持深度值和左度值
    // 一旦遇到更左下角的就替换
    public int findBottomLeftValue(TreeNode root) {
        search(root, 1, 1);
        return resVal;
    }


    // 其实也很接近正确的dfs了，只不过在更新值的时候逻辑错误
    public void search(TreeNode node, int depth, int lefth) {
        if (node.left == null && node.right == null) {
            if (depth > depthest ||
                    (depth == depthest && lefth > lefthest)) {
                depthest = depth;
                lefthest = lefth;
                resVal = node.val;
            }
        }

        if (node.left != null) {
            search(node.left, depth + 1, lefth + 1);
        }

        if (node.right != null) {
            search(node.right, depth + 1, lefth - 1);
        }
    }
}
