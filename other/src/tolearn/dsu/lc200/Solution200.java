package tolearn.dsu.lc200;

public class Solution200 {
    static int n, m, ans;
    static boolean[][] visited;

    // 普通dfs解法
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;

        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    // 计算岛屿数量
    // dfs类似 kamacode/p103/Main.java 的处理方式，都是把所有基准情况到第一个if中统一处理（不符合的情况）
    // 后面dfs直接调用即可，不需要担心考虑越界情况
    public static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || grid[i][j] != '1') {
            return;
        }

        visited[i][j] = true;
        // 采用统一处理的不带if的dfs形式
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
