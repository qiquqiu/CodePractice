package problems.lq149;

import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/149/learning/?page_size=10&first_category_id=1&tags=%E7%9C%81%E6%A8%A1%E6%8B%9F%E8%B5%9B&origin=cup&page=1
 */
public class Main149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine(); // 消掉换行回车
        int[][] ground = new int[n][m]; // 0为空地，非0为第几个月的草

        // 读入初始数据
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < m; j++) {
                if (input.charAt(j) == 'g') {
                    ground[i][j] = 1;
                }
            }
        }

        int k = sc.nextInt(); // 读入月份数
        for (int i = 1; i <= k; i++) { // 循环k次
            // 第i个月就让第i代的草生长
            grow(ground, i);
        }

        // 遍历输出结果
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ground[i][j] == 0) {
                    System.out.print(".");
                } else {
                    System.out.print("g");
                }
            }
            System.out.println();
        }
    }

    /**
     * 让土地上的草生长
     * @param ground 土地数组
     * @param generation 让第几代的草生长，数组中值就为几（初始为1）
     */
    public static void grow(int[][] ground, int generation) {
        int n = ground.length;
        int m = ground[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ground[i][j] == generation) {
                    // 只向四周空地方向长
                    if (i - 1 >= 0 && ground[i - 1][j] == 0) {
                        ground[i - 1][j] = generation + 1;
                    }
                    if (i + 1 < n && ground[i + 1][j] == 0) {
                        ground[i + 1][j] = generation + 1;
                    }
                    if (j - 1 >= 0 && ground[i][j - 1] == 0) {
                        ground[i][j - 1] = generation + 1;
                    }
                    if (j + 1 < m && ground[i][j + 1] == 0) {
                        ground[i][j + 1] = generation + 1;
                    }
                }
            }
        }
    }
}
