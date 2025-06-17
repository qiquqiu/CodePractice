package problems.lq152;

import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/152/learning/?page_size=10&first_category_id=1&tags=%E7%9C%81%E6%A8%A1%E6%8B%9F%E8%B5%9B&origin=cup&page=1
 */
public class Main152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // 可暴力，可递归（暴力）
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i % a != 0 && i % b != 0 && i % c != 0) {
                ans++;
            }
        }
        System.out.print(ans);
    }
}
