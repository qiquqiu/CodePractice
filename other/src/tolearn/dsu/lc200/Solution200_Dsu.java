package tolearn.dsu.lc200;

import tolearn.dsu.DisjointSetUnion;

/**
 * 使用并查集解法，AC
 * 但是显然不如直接dfs直观和简单
 */
public class Solution200_Dsu {
    DisjointSetUnion<Integer> dsu;
    int n, m;

    // 使用并查集解决
    public int numIslands(char[][] grid) {
        dsu = new DisjointSetUnion<>();
        n = grid.length;
        m = grid[0].length;

        // 不必初始化
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    checkAndAdd(grid, i, j);
                }
            }
        }

        return dsu.getComponentCount();
    }

    // 检查陆地i，j周围是否有其他陆地，如果有则添加
    public void checkAndAdd(char[][] grid, int i, int j) {
        int id = calId(i, j);
        dsu.add(id);  // 确保当前陆地已初始化

        // 上
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            dsu.join(id, calId(i - 1, j));
        }
        // 下
        if (i + 1 < n && grid[i + 1][j] == '1') {
            dsu.join(id, calId(i + 1, j));
        }
        // 左
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            dsu.join(id, calId(i, j - 1));
        }
        // 右
        if (j + 1 < m && grid[i][j + 1] == '1') {
            dsu.join(id, calId(i, j + 1));
        }
    }

    // 简单的将左边转为唯一id的算法
    public int calId(int i, int j) {
        return i * m + j;
    }
}
