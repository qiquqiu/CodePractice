package liststackqueue.lc145;

import treerecursion.lc100.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution145 {
    ArrayList<Integer> list = new ArrayList();
    Stack<TreeNode> stack = new Stack<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode cur = root;
        TreeNode popped = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode peeked = stack.peek();
                if (peeked.right == null || peeked.right == popped) {
                    list.add(stack.pop().val); // 左、右、根中的“根”
                    popped = peeked; // 更新弹出的节点
                } else {
                    cur = peeked.right;
                }
            }
        }
        return list;
    }
}
