package bilibiliway.type3_dfs;

import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P8786
 * 一遍OK只达到40%的通过，也就是暴力的数据能用该dfs算是能拿到分
 */
public class Main5 {
    static int n;
    static int m;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 店的个数
        m = sc.nextInt(); // 花的个数
        ans = 0;

        // 按照集合的搜索思路，就是搜索店和花的所有组合的集合下
        // 若遍历到第n+m个单位，且判断是花，且将酒更新完毕之后为0才将ans+1

        dfs(2, n, m, 0);
        System.out.println(ans);
    }

    /**
     * @param last 上一个是店1，还是花0
     */
    public static void dfs(int wine, int hotelRest, int flowerRest, int last) {
        if (hotelRest + flowerRest == 0) {
            // 到了最后一个单位
            if (last == 0 && wine == 0) {
                ans++;
            }
            return;
        }

        // 注意这里并不是无脑套模板for
        // 注意这里处理的逻辑的核心是什么，核心逻辑是：针对当前位置这一个位置的搜索
        // 既然是针对一个位置的搜索，自然要考虑可能的情况，而此题这里可能的情况就是0或者1；所以相当于2.for且无需判重回溯（因为有店、花余量控制）
        if (hotelRest > 0) {
            dfs(wine * 2, hotelRest - 1, flowerRest, 1);
        }
        if (flowerRest > 0 && wine != 0) {
            dfs(wine - 1, hotelRest, flowerRest - 1, 0);
        }
    }
}
