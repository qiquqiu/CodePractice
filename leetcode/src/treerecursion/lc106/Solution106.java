package treerecursion.lc106;

import treerecursion.lc100.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *   思路分析
 * 第一步：从后序遍历中找到最右边的值，作为val创建第一次的根节点，并将之删除
 * 第二步：在中序遍历中找到上一步保存的根节点的值，将其左右分割开来
 *        如果其左或者右有哪边只有一个值了，那么它的左或者右子节点直接就
 *        指向这个值，否则
 * 第三步：如果第一步从后序遍历中找到的（局部）根节点在第二步中属于“否则”
 *        那么以“inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]”
 *        为例子，如果此时第一步中找到的根节点在inorder序列的右边是一个子树
 *        而非仅仅是一个节点，那么记录下右子树的所有值，再到postorder中
 *        从后向前找，找到的第一个属于刚才记录下的值中的那个就是该子树的根节点
 *        找到后，记录该子树的根节点并且将之从postorder中删除
 * 第四步：拿着刚才获得的子树的节点值，在第三步所保存的含全部子树序列的子数组中
 *        重复第二第三步
 * 总结：递归的思路，每次在给我们的参数postorder中找在给我们的参数inorder中
 * 第一次在postorder中出现的数据保存并删除，再在inorder中按照该值分割左右
 * 子数组，若有长度为1的子数组则进入基准情况，否则递归。
 * 但是第一遍中的难点在于：如果让根节点能够连接到左右子树上？这里的连接是一个难题
 * 初步解决方案是修改递归函数的返回值为TreeNode也就是每次获得的新的根节点
 */
public class Solution106 {
    /**
     * 根据中序遍历和后序遍历构造二叉树
     *
     * @param inorder   中序遍历结果
     * @param postorder 后序遍历结果
     * @return 结果二叉树的根节点
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 显然是可以进行进一步优化的
        return build(arr2Set(inorder), inorder, postorder);
    }

    public TreeNode build(Set<Integer> inorderSet, int[] inorder, int[] postorder) {
        int newRootVal = 0;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (inorderSet.contains(postorder[i])) {
                newRootVal = postorder[i];
                break;
            }
        }

        TreeNode newRoot = new TreeNode(newRootVal);

        // 这里要考虑防止长度越界
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }

        // 注意，此处的两个boolean变量仅仅表示“左/右边只有一个数据”
        // 并不能保证左右边无数据时候发生改变
        boolean leftIsOne = false;
        boolean rightIsOne = false;

        if (inorder[1] == newRootVal) {
            newRoot.left = new TreeNode(inorder[0]);
            leftIsOne = true;
        }
        if (inorder[inorder.length - 2] == newRootVal) {
            newRoot.right = new TreeNode(inorder[inorder.length - 1]);
            rightIsOne = true;
        }

        // 每次过后postorder数组其实可以不用改动，反正我们总是要查找的
        // 并且如果按照这个每次删除最后一的有时候并非最后一个就是需要的根节点
//        int[] newPostorder = Arrays.copyOfRange(postorder, 0, postorder.length - 1);

        if (leftIsOne && !rightIsOne) {
            int[] newInorder = Arrays.copyOfRange(inorder, getRootIndex(inorder, newRootVal) + 1, inorder.length);
            if (newInorder.length != 0) {
                newRoot.right = build(arr2Set(newInorder), newInorder, postorder);
            }
        } else if (!leftIsOne && rightIsOne) {
            int[] newInorder = Arrays.copyOfRange(inorder, 0, getRootIndex(inorder, newRootVal));
            if (newInorder.length != 0) {
                newRoot.left = build(arr2Set(newInorder), newInorder, postorder);
            }
        } else if (!leftIsOne && !rightIsOne) {
            int[] newLeftInorder = Arrays.copyOfRange(inorder, 0, getRootIndex(inorder, newRootVal));
            int[] newRightInorder = Arrays.copyOfRange(inorder, getRootIndex(inorder, newRootVal) + 1, inorder.length);
            if (newLeftInorder.length != 0) {
                newRoot.left = build(arr2Set(newLeftInorder), newLeftInorder, postorder);
            }
            if (newRightInorder.length != 0) {
                newRoot.right = build(arr2Set(newRightInorder), newRightInorder, postorder);
            }
        }
        // if-else链还有一种情况不需要递归，直接一次return即可
        return newRoot;
    }

    public Set<Integer> arr2Set(int[] arr) {
        // 实际上题目已经保证了是由不同的值构成
        // 所以这里使用HashSet的目的其实是快速判断是否包含
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
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
