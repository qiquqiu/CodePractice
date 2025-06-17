package treerecursion.lc113;

import treerecursion.lc100.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution113_simplified {
    // 可大大优化了时间
    List<List<Integer>> res;
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        target = targetSum;
        if (root == null) {
            return res;
        }
        dfs(root, 0, new ArrayList<>());
        return res;
    }

    public void dfs(TreeNode node, int sum, List<Integer> path) {
        path.add(node.val);
        if (node.left == null && node.right == null && sum + node.val == target) {
            // 这里必须新开辟一个‘对象’
            // 这里如果直接写成res.add(path)的话，固然是把这次的path添加进去了
            // 但是要知道，自始自终path在堆内存中就只有一个对象
            // List<引用数据类型>，中存的是引用，第二次path修改后，第一个添加的path也变动了
            // 就是这么个意思 https://yiyan.baidu.com/share/m41L3wTfov
            res.add(new ArrayList<>(path));
            return;
        }
        if (node.left != null) {
            dfs(node.left, sum + node.val, path);
            path.removeLast();
        }
        if (node.right != null) {
            dfs(node.right, sum + node.val, path);
            path.removeLast();
        }
    }
}
