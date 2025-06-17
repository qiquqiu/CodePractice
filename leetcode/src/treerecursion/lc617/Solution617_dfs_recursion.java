package treerecursion.lc617;

import treerecursion.lc100.TreeNode;

public class Solution617_dfs_recursion {
    // 合并两个二叉树
    // 一眼看出的思路有两种，一是层序遍历，一是递归
    // 也就是说，一是bfs，一是dfs


    // 该递归函数，搞明白关键的一点就好了：在递归的思维时，直接进行的“合并”这种
    // 操作应该是作为基准情况的，也就是作为对根节点的操作的
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 通过每次构建的用于收集节点和的新节点来构建新树
        TreeNode resNode;
        if (root1 != null && root2 != null) {
            // root1和root2均不为null
            resNode = new TreeNode(root1.val + root2.val);
            resNode.left = mergeTrees(root1.left, root2.left);
            resNode.right = mergeTrees(root1.right, root2.right);
        } else if (root1 == null && root2 != null) {
            // root1为null但是root2不为null
            resNode = new TreeNode(root2.val);
            resNode.left = mergeTrees(null, root2.left);
            resNode.right = mergeTrees(null, root2.right);
        } else if (root1 != null && root2 == null) {
            // root1不为null，但是root2为null
            resNode = new TreeNode(root1.val);
            resNode.left = mergeTrees(root1.left, null);
            resNode.right = mergeTrees(root1.right, null);
        } else {
            // root1和root2均为null
            return null;
        }

        // 非最后一个else时候就是通过这里返回（非null）
        return resNode;
    }
}

// 提交结果：1ms，成功，注意细节，第一版本的写法是，四种情况下的if-else，然后在后面直接加上这两行
//            resNode.left = mergeTrees(root1.left, root2.left);
//            resNode.right = mergeTrees(root1.right, root2.right);
// 直接无脑向左右递归，但是要小心空指针问题，显然不能直接在这外面加上对root1和root2的均不为null的限制
// 如果直接这么做就会导致下面的问题：
// 因为虽然对于本题例子没有影响，但是对于中间两种if-else的情况，就会导致，当子树A下面还有很长的一串的时候
// 但是子树B已经是null了（这里的A,B是由节点代指）,那么就会直接返回A，导致A下面都不会有机会被递归到!
// 所以要在不同情况里面分别写递归
