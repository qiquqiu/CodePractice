package tolearn.dsu;

import java.util.Scanner;

/**
 * 题目：给定n个人和m对朋友关系，问有多少个朋友圈（连通分量）？
 */
public class Demo {
    public static void main(String[] args) {
        // 练习并查集的使用
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 人数
        int m = sc.nextInt(); // 朋友关系对数

        // 用人的编号表示人
        DisjointSetUnion<Integer> dsu = new DisjointSetUnion<>();

        for (int i = 1; i <= n; i++) {
            // 初始化人
            dsu.add(i);
        }

        // 录入关系数据
        for (int i = 0; i < m; i++) {
            dsu.join(sc.nextInt(), sc.nextInt());
        }

        // 找该并查集中有几个连通分量，由于使用了路径压缩，所以找有几个根即可
        System.out.println(dsu.getComponentCount());
    }
}
