package treerecursion.lc654;

import treerecursion.lc100.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution654 {
    // 又是一道递归分治思路的题
    Map<Integer, Integer> map; // 保存值与索引，方便根据值查找索引

    /*
     * 题目描述：
     * 给定一个不重复的整数数组 nums 最大二叉树 可以用下面的算法从 nums 递归地构建:
     * 创建一个根节点，其值为 nums 中的最大值。
     * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
     * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
     * 返回 nums 构建的 最大二叉树
     *
     * 注意，题目保证：
     * （1）nums 中的所有整数 互不相同
     * （2）0 <= nums[i] <= 1000
     *
     * */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 源数组的值做键，索引做值
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        // 例子：{3, 2, 1, 6, 0, 5}

        // 这里有个细节，由于我们递归函数设定为操作区间为左闭右开
        // 所以说即便不是递归调用处，也要遵守，这里就直接nums.length了
        // 而不是nums.length - 1
        return build(nums, 0, nums.length);
    }

    // 区间默认左闭右开
    public TreeNode build(int[] nums, int begin, int end) {
        // 因为我们的所有其他操作都是遵循我们所设定的区间规则
        // 所以说一旦区间不符合规则，那么就说明操作到末尾了
        if (begin >= end) {
            // 左闭右开区间不符合规则的触发条件
            return null;
        }

        // 从这一步开始就要求能够一定程度预判下面的递归
        // 我们已经要知道将要分治左右递归
        int maxVal = getMaxVal(nums, begin, end);
        int indexOfMaxVal = map.get(maxVal); // 获取索引，给下次用判定范围

        TreeNode root = new TreeNode(maxVal);

        root.left = build(nums, begin, indexOfMaxVal);
        root.right = build(nums, indexOfMaxVal + 1, end);

        return root;
    }

    // 从数组指定区间内获取最大值
    public int getMaxVal(int[] arr, int begin, int end) {
        // 这里内部就不需要对区间做合理判定了，不合理就不会进来的
        int max = arr[begin];
        for (int i = begin; i < end; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
