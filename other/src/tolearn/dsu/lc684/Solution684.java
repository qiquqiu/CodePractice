package tolearn.dsu.lc684;

import tolearn.dsu.DisjointSetUnion;

public class Solution684 {
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSetUnion<Integer> dsu = new DisjointSetUnion<>();

        int[] ans = new int[2];
        // 调用join构建连通分量
        for (int[] edge : edges) {
            dsu.add(edge[0]);
            dsu.add(edge[1]);
            if (dsu.isConnected(edge[0], edge[1])) {
                // 则是冗余边，不必join，跳过即可
                ans = edge;
            } else {
                dsu.join(edge[0], edge[1]);
            }
        }

        return ans;
    }
}
