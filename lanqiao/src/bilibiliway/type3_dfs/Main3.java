package bilibiliway.type3_dfs;

import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P9241
 * 题目数据说明：1≤T≤10，1≤N≤10， 可以看出应当是要用dfs的
 * AC
 */
public class Main3 {
    static short[] isLand;
    static int n;
    static int[] early, late, cost;
    static boolean isOK;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        for (int l = 0; l < loop; l++) {
            n = sc.nextInt();
            early = new int[n];
            late = new int[n];
            cost = new int[n];
            isLand = new short[n]; // isLand 默认值表示没能成功降落，1表示能成功降落

            for (int i = 0; i < n; i++) {
                early[i] = sc.nextInt();
                late[i] = early[i] + sc.nextInt();
                cost[i] = sc.nextInt();
            }

            // 开始搜索，每个飞机都可以作为第一个
            dfs(0, 0);
            System.out.println(isOK ? "YES" : "NO");
            isOK = false;
        }
    }

    // preLandTime:上一个飞机降落完成时间
    public static void dfs(int landCnt, int preLandTime) {
        // 支持更新状态的条件就是：当前飞机的开始降落时间'能够'大于等于上一个飞机的降落完成时间lastLandTime
        if (landCnt == n) {
            // 全部飞机都遍历过一遍
            isOK = true; // 必须使用cnt+isOK两个变量联动才能判断是否全可降落，不能仅仅在循环外面凭借cnt是否=n判断，因为cnt在下一行的return后会回溯减掉
            return;
        }

        for (int k = 0; k < n; k++) { // 循环是必要的，不然顺序就只能是i，i+1，i+1+1...
            if (isLand[k] == 0 && late[k] >= preLandTime) { // 已经降落的飞机就不管了
                isLand[k] = 1;
                // 当前飞机的最晚完成降落时间：Math.max(early[i], preLandTime) + cost[i]（画图即可）
                dfs(landCnt + 1, Math.max(early[k], preLandTime) + cost[k]);
                // 回溯，防止影响后续循环
                isLand[k] = 0;
            }
        }
    }
}
