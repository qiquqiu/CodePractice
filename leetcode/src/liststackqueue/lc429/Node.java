package liststackqueue.lc429;

import java.util.List;

// 这是一个多叉树
public class Node {
    public int val;
    public List<Node> children; // 子节点是一个列表（默认从左到右）

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
