package tolearn.dsu;

import java.util.HashMap;
import java.util.Map;

/**
 * 并查集模板类:要求实现泛型必须重写equals方法
 * 并且并查集father中的元素初始化的时候，必须初始化为<x, x>的格式
 * 并查集就是一系列顶点和边组成的一个或者多个树（图）的集合，即森林
 * 并查集内的边都是双向连通的
 */
public class DisjointSetUnion<T> {
    private final Map<T, T> father = new HashMap<>(); // <T, T> ---> <x, father[x]>
    private int componentCount = 0; // 初始化为0

    public DisjointSetUnion() {
    }

    // 向并查集中添加顶点
    public boolean add(T x) {
        if (!father.containsKey(x)) {
            // 由于并不知大小，所以在添加的时候初始化初始化自环
            father.put(x, x);
            componentCount++;
            return true;
        }
        return false;
    }

    // 添加一条边
    public void join(T u, T v) {
        // 添加边的同时也做顶点的非空判断，对性能并无大影响
        // 若能保障已经先添加了所有的顶点，可以去掉下两行
        add(u);
        add(v);

        u = find(u);
        v = find(v);
        if (!u.equals(v)) {
            // 若不是同一个父根，设置u作为v的父根
            father.put(v, u);
            componentCount--;
        }
    }

    // 寻找x的父节点
    public T find(T x) {
        // 如果x不是根节点，就按照“设置x的父节点为x的爷节点”递归
        if (!x.equals(father.get(x))) {
            // 寻找的同时进行路径压缩
            father.put(x, find(father.get(x)));
        }
        // 如果x就是根节点直接返回x
        return x;
    }

    // O(1)获取连通分量数
    public int getComponentCount() {
        return componentCount;
    }

    // 判断两个元素是否位于同一个连通分量（当前维护的father集合）
    public boolean isConnected(T u, T v) {
        return find(u).equals(find(v));
    }
}
