package treerecursion.lc113;

import treerecursion.lc100.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution113 {
    List<List<Integer>> res;
    int target;

    // 与lc257、lc112都是类似的题
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        target = targetSum;
        if (root == null) {
            return res;
        }
        dfs(root, 0, new ArrayList<>());
        return res;
    }

    // 用时有点长了
    // 抛开strList2IntList(...)方法不看，单看dfs这个方法
    // 这个递归回溯方法的参数设计，既使用到了局部变量（基本数据类型），也使用到了共享的变量（引用数据类型）
    // 而且这两个变量都是要用来存每个当前节点的信息的（保存当前栈帧信息），所以这两个变量都要
    // 参与回溯，好好结合lc257和lc112来体会这里是如何保证回溯成功的
    public void dfs(TreeNode node, int sum, List<String> path) {
        path.add(node.val + " ");
        if (node.left == null && node.right == null && sum + node.val == target) {
            res.add(strList2IntList(path));
            return;
        }
        if (node.left != null) {
            dfs(node.left, sum + node.val, path);
            // 这里的显示回溯可以这么理解，假设当前层下的一个节点就是叶子节点了
            // 那么由于每个栈帧时候我们都会先进行path.add(node.val + " ");
            // 且第一个if会判断成功（不过这不是重点），这里的path.removeLast();
            // 所remove的，就是下一层栈帧中一进去就执行的添加操作
            // 实际上不管下一个节点是不是叶子节点，因为都会一进去就添加，所以说，
            // 我们这里的remove就是删掉的紧接着的下一层所多添加的那个，从而使得
            // 每层时候的path总是只保存到截止当前节点的路径值
            path.removeLast();
        }
        if (node.right != null) {
            dfs(node.right, sum + node.val, path);
            // 这里同理
            path.removeLast();
        }
    }

    // 这个东西提高了时间复杂度，后续再考虑优化吧
    // 实际上之所以这么做是有原因的(跟引用数据path引用未变有关)，这里同时也附上原因和解决方案
    // https://leetcode.cn/problems/path-sum-ii/description/comments/1440262
    // https://yiyan.baidu.com/share/m41L3wTfov
    public List<Integer> strList2IntList(List<String> path) {
        List<Integer> integers = new ArrayList<>();
        for (String s : path) {
            integers.add(Integer.parseInt(s.trim()));
        }
        return integers;
    }
}
