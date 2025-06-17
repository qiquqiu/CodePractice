package treerecursion.lc98;

import treerecursion.lc100.TreeNode;

public class Solution_official1 {
    TreeNode pre = null;

    // 结合Carl视频讲解
    // https://www.bilibili.com/video/BV18P411n7Q4
    // 来理解，其实当前的root与pre就构成了一对双指针，我们通过不断移动这个两个指针来比较是否符合“BST中序特性”
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 中序遍历的“左”，直接递归！
        boolean left = isValidBST(root.left);

        // 中序遍历的“中”，分是不是“第一次判断”来进行比较
        if (pre != null) {
            // 这一步结合Carl视频中的图解，难点：1.设置pre 2.如何return
            // 1.设置pre的过程一定要与中序遍历同步：即先向左遍历到第一个叶子节点
            // 才开始中、右，同理pre一直向左找到第一个叶子节点，然后返回上一层
            // 注意，这里的pre与root的相对顺序是“在中序遍历结果序列中的相对顺序”
            // 而不是父节点，子节点的顺序
            if (root.val <= pre.val) {
                return false;
            }
            // 2.注意这里的return操作：如果不符合了，就当及return false
            // 但若是符合，就继续比较下去，不要在这里直接return true
            // 因为右子树部分还未判断！return了就结束了
        }
        // 当前节点，即“中”比较完之后，即将进入后面继续递归
        // 为下一次递归将pre更新为当前root
        pre = root;

        // 中序遍历的“右”
        boolean right = isValidBST(root.right);

        return left && right;
    }
}