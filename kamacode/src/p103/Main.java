package p103;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://kamacoder.com/problempage.php?pid=1175
 * AC
 * 优化考虑：这个解法可以通过，但是时长有点长，visited数组开销也比较大
 * 可以参考 https://www.programmercarl.com/kamacoder/0103.%E6%B0%B4%E6%B5%81%E9%97%AE%E9%A2%98.html#%E4%BC%98%E5%8C%96
 * 进行逆向思维的优化，即从两种边界处开始遍历，逆流而上，最后两个遍历结果的公共点就是答案
 */
public class Main {
    static boolean[][] visited;
    static boolean flag1;
    static boolean flag2;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] area = new int[n][m];
        // 录入地形图
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                area[i][j] = sc.nextInt();
            }
        }

        ArrayList<String> list = new ArrayList<>();
        // dfs遍历得到所能延申的区域极限
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                flag1 = flag2 = false;
                visited = new boolean[n][m];
                dfs(area, i, j);
                if (flag1 && flag2) {
                    list.add(i + " " + j);
                }
            }
        }

        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void dfs(int[][] area, int i, int j) {
        if (i == 0 || j == 0) {
            flag1 = true;
        }
        if (i == n - 1 || j == m - 1) {
            flag2 = true;
        }
        visited[i][j] = true;
        if (i - 1 >= 0 && !visited[i - 1][j] && area[i - 1][j] <= area[i][j]) {
            dfs(area, i - 1, j);
        }
        if (i + 1 < n && !visited[i + 1][j] && area[i + 1][j] <= area[i][j]) {
            dfs(area, i + 1, j);
        }
        if (j - 1 >= 0 && !visited[i][j - 1] && area[i][j - 1] <= area[i][j]) {
            dfs(area, i, j - 1);
        }
        if (j + 1 < m && !visited[i][j + 1] && area[i][j + 1] <= area[i][j]) {
            dfs(area, i, j + 1);
        }
    }
}
