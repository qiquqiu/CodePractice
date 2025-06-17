package treerecursion.lc105;

import treerecursion.lc100.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution105 {
    Map<Integer, Integer> map;

    // 与lc106是一个思路，只不过此题是“根据前序遍历结果和中序遍历结果构建树”
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 存中序遍历结果序列的值与其索引（数组值为键，数组索引为值），反正不会重复
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    // 这里区间的标准默认均为左闭右开
    public TreeNode build(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        if (preBegin >= preEnd || inBegin >= inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preBegin]);
        int rootIndex = map.get(preorder[preBegin]);

        int leftLength = rootIndex - inBegin;

        root.left = build(preorder, preBegin + 1, preBegin + 1 + leftLength,
                inorder, inBegin, rootIndex);

        root.right = build(preorder, preBegin + 1 + leftLength, preEnd,
                inorder, rootIndex + 1, inEnd);

        return root;
    }
}
