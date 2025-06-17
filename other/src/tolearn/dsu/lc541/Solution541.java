package tolearn.dsu.lc541;

import tolearn.dsu.DisjointSetUnion;

// AC ？？？
public class Solution541 {
    public int findCircleNum(int[][] isConnected) {
        DisjointSetUnion<Integer> dsu = new DisjointSetUnion<>();
        int n = isConnected.length;

        for (int i = 0; i < n; i++) {
            dsu.add(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 这里做了两个修改，一个是吧j从i开始，即只遍历半边矩阵即可
                // 另一个是由于之前统一add初始化过，所以i=j的自环点无需遍历
                // 可以合并成 j=i+1 开始
                if (isConnected[i][j] == 1) {
                    dsu.join(i, j);
                }
                if (dsu.getComponentCount() == 1) {
                    // 如果已经全部连通，提前退出：优化1ms
                    return 1;
                }
            }
        }

        return dsu.getComponentCount();
    }
}
