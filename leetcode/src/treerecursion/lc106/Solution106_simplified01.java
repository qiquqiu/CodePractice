package treerecursion.lc106;

import treerecursion.lc100.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Solution106_simplified01 {
    // 较第一版优化版-optimization，这只是小优化，显然还可以更优化一些，如引入查找函数
    // 从而省略掉哈希表的应用和构建
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(arr2Set(inorder, 0, inorder.length - 1), inorder, postorder, 0, inorder.length - 1);
    }

    // 不用每次都调用 Arrays.copyOfRange 方法，只需要传一个inorder的相对原始inorder的有效起始区间即可（默认闭区间）
    public TreeNode build(Set<Integer> inorderSet, int[] inorder, int[] postorder, int start, int end) {
        int newRootVal = 0;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (inorderSet.contains(postorder[i])) {
                newRootVal = postorder[i];
                break;
            }
        }

        TreeNode newRoot = new TreeNode(newRootVal);

        // 这里要考虑防止长度越界
        if (start == end) {
            return new TreeNode(inorder[start]);
        }

        // 注意，此处的两个boolean变量仅仅表示“左/右边只有一个数据”
        // 并不能保证左右边无数据时候发生改变
        boolean leftIsOne = false;
        boolean rightIsOne = false;

        if (inorder[start + 1] == newRootVal) {
            newRoot.left = new TreeNode(inorder[start]);
            leftIsOne = true;
        }
        if (inorder[end - 1] == newRootVal) {
            newRoot.right = new TreeNode(inorder[end]);
            rightIsOne = true;
        }

        // 每次过后postorder数组其实可以不用改动，反正我们总是要查找的
        // 并且如果按照这个每次删除最后一个的思路也是错的，的有时候并非最后一个就是需要的根节点
//        int[] newPostorder = Arrays.copyOfRange(postorder, 0, postorder.length - 1);

        // 要么每次切割inorder（同时也要切割其哈希表），要么每次同时切割inorder和postorder
        // 我这里只是切割了inorder，并没有对postorder做处理，这是因为，题目保证树不含有重复值
        // 也就是说，每次截取的inorder与初始（也就是一直使用的）postorder的交集在postorder中的补集
        // 中是不可能出现inorder中重复的元素的...
        if (leftIsOne && !rightIsOne) {
            int newStart = getRootIndex(inorder, newRootVal) + 1;
            int newEnd = end;
            if (newStart != newEnd + 1) {
                newRoot.right = build(arr2Set(inorder, newStart, newEnd), inorder, postorder, newStart, newEnd);
            }
        } else if (!leftIsOne && rightIsOne) {
            int newStart = start;
            int newEnd = getRootIndex(inorder, newRootVal) - 1;
            if (newStart != newEnd + 1) {
                newRoot.left = build(arr2Set(inorder, newStart, newEnd), inorder, postorder, newStart, newEnd);
            }
        } else if (!leftIsOne && !rightIsOne) {
            int newLeftStart = start;
            int newLeftEnd = getRootIndex(inorder, newRootVal) - 1;
            int newRightStart = getRootIndex(inorder, newRootVal) + 1;
            int newRightEnd = end;
            if (newLeftStart != newLeftEnd + 1) {
                newRoot.left = build(arr2Set(inorder, newLeftStart, newLeftEnd), inorder, postorder, newLeftStart, newLeftEnd);
            }
            if (newRightStart != newRightEnd + 1) {
                newRoot.right = build(arr2Set(inorder, newRightStart, newRightEnd), inorder, postorder, newRightStart, newRightEnd);
            }
        }
        // if-else链还有一种情况不需要递归，直接一次return即可
        return newRoot;
    }

    public Set<Integer> arr2Set(int[] arr, int start, int end) {
        // 实际上题目已经保证了是由不同的值构成
        // 所以这里使用HashSet的目的其实是快速判断是否包含
        Set<Integer> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            set.add(arr[i]);
        }
        return set;
    }

    public int getRootIndex(int[] curInOrder, int val) {
        for (int i = 0; i < curInOrder.length; i++) {
            if (curInOrder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
