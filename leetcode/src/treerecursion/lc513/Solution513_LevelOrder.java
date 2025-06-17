package treerecursion.lc513;

import treerecursion.lc100.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution513_LevelOrder {
    // 相当于bfs
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode firstOfEachLevel = null;

        while (!queue.isEmpty()) {
            int size = queue.size();
            firstOfEachLevel = queue.peek();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return firstOfEachLevel.val;
    }
}
