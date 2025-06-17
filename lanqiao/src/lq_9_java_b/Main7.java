package lq_9_java_b;

import java.util.*;

public class Main7 {
    static int n;
    static List<HashSet<String>> pre = new ArrayList<>();

    public static void main(String[] args) {
        // 最终需要有一个函数计算地图中的岛屿数量
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        // 录入数据
        char[][] origin = new char[n][n]; // 原始岛屿
        char[][] arr = new char[n][n]; // 备份数据
        for (int i = 0; i < n; i++) {
            origin[i] = sc.nextLine().toCharArray();
            System.arraycopy(origin[i], 0, arr[i], 0, n);
        }
        sc.close();

        recordOriginalIslands(origin);

        // 模拟淹没
        simulateFlood(arr);

        int ans = countFloodedIslands(arr);

        System.out.println(ans);
    }

    private static void simulateFlood(char[][] arr) {
        // 标记会被淹没的陆地
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '.') {
                    floodAdjacent(arr, i, j);
                }
            }
        }
        // 应用淹没
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '$') {
                    arr[i][j] = '.';
                }
            }
        }
    }

    private static void floodAdjacent(char[][] arr, int i, int j) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < n && y >= 0 && y < n && arr[x][y] == '#') {
                arr[x][y] = '$';
            }
        }
    }

    private static void dfs(char[][] arr, int i, int j, HashSet<String> island) {
        if (i < 0 || i > n - 1 || j < 0 || j > n - 1 || arr[i][j] == '@' || arr[i][j] == '.') {
            return;
        }
        // 否则说明当前是陆地，向四方继续遍历
        // 先将当地标记为已经访问
        arr[i][j] = '@';
        island.add(i + " " + j);

        dfs(arr, i - 1, j, island);
        dfs(arr, i + 1, j, island);
        dfs(arr, i, j - 1, island);
        dfs(arr, i, j + 1, island);
    }

    private static int countFloodedIslands(char[][] floodedMap) {
        int count = 0;
        for (HashSet<String> island : pre) {
            boolean isFlooded = true;
            for (String land : island) {
                String[] parts = land.split(" ");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                if (floodedMap[x][y] == '#') {
                    isFlooded = false;
                    break;
                }
            }
            if (isFlooded) {
                count++;
            }
        }
        return count;
    }

    // 记录淹没之前剩余几块陆地
    private static void recordOriginalIslands(char[][] origin) {
        HashSet<String> island = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (origin[i][j] == '#') {
                    island.clear();
                    dfs(origin, i, j, island);
                    if (!island.isEmpty()) {
                        pre.add(new HashSet<>(island));
                    }
                }
            }
        }
    }
}
