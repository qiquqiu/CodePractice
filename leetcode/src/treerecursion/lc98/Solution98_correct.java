package treerecursion.lc98;

import treerecursion.lc100.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution98_correct {
    // 修正结果如下：
    // 关键知识点：二叉搜索树中序遍历结果一定是升序排列！
    // 根据“BST中序遍历严格单调递增”这一特性衍生的“类暴力”解法
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        midOrder(root, list);
        return isStrictAscendingOrder(list);
    }

    public void midOrder(TreeNode node, List<Integer> list) {
        if (node.left != null) {
            midOrder(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            midOrder(node.right, list);
        }
    }

    public boolean isStrictAscendingOrder(List<Integer> list) {
        if (list == null || list.size() < 2) {
            return true;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
