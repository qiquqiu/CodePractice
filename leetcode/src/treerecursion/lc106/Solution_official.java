package treerecursion.lc106;

import treerecursion.lc100.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution_official {
    // 官方最优解
    Map<Integer, Integer> map;  // 方便根据数值查找位置，神来之笔
    // 注意Line37,值得说明的是，尽管每次我们递归的时候都对数组进行了“切割”，但是这个“切割”
    // 只是模拟的，也就是说我们的“切割”实际上只是给定下次递归时访问数组的范围，所以说
    // 我们仍然可以使用这个保存了原始数组信息的map；并且 lenOfLeft 的计算也不会有问题
    // 因为原始数组压根没变，而且我们传入的访问范围都是原数组的索引

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) { // 用map保存中序序列的数值对应位置
            map.put(inorder[i], i);
        }

        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);  // 前闭后开
    }

    // 参数里的范围都是前闭后开
    public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        // 这里先书写基准情况，要能够一定程度预判下面的递归区域，不要求判断下面完整代码
        // 至少能够预判下面将要写的递归调用地方整体功能
        // 不用把“当分割所得的中序区间只有一个数据”作为一种基准情况，从而在彼处直接添加
        // 因为“当分割所得的中序区间只有一个数据”的时候，也是可以继续递归来进行这个看似“直接”的添加的
        // 而如果将之在外面单独写为基准情况还要考虑当区间为0的时候的限制等等。
        // 所谓基准情况，就是结束递归调用的栈帧所符合的情况，理解递归的“重复某一个元操作”性质后
        // 自然就不会把只有1个的时候就赶紧作为基准情况
        if (inBegin >= inEnd || postBegin >= postEnd) {  // 不满足左闭右开，说明没有元素，返回空树
            return null;
        }

        int rootIndex = map.get(postorder[postEnd - 1]);  // 找到后序遍历的最后一个元素在中序遍历中的位置
        TreeNode root = new TreeNode(inorder[rootIndex]);  // 构造结点

        int lenOfLeft = rootIndex - inBegin;  // 保存中序左子树个数，用来确定后序数列的个数

        // 既分割inorder又分割postorder；先分割inorder后分割postorder
        // 有点类似与归并排序、快速排序的左右递归分而治之，实际上也确实如此，分开左右分别递归
        // 让左右分别去递归执行“元操作”。
        // 将本栈帧情况分为两部分，分左递归与右递归，这是一种典型的分治思想。
        root.left = findNode(inorder, inBegin, rootIndex,
                postorder, postBegin, postBegin + lenOfLeft);
        // 由于后序遍历的整体顺序是“左右中”，只不过左右是从头就开始的，
        // 所以说分割后序数组的时候顺序与分割中序数组一样
        // 都是先分割左后序，再分割右后序
        root.right = findNode(inorder, rootIndex + 1, inEnd,
                postorder, postBegin + lenOfLeft, postEnd - 1);

        return root;
    }
}
