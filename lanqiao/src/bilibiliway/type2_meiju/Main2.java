package bilibiliway.type2_meiju;

import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/contest/90960/D
 * 枚举
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        // 思路，枚举某一个技能的使用次数，求出另外一个技能的使用次数
        int aoeMaxCnt = (int) Math.ceil(Math.max(a, b) / (double) y); // 范围技能的最大使用次数
        int ans = aoeMaxCnt;

        // 枚举范围技能的每个使用次数下的单体技能的使用次数
        for (int i = 0; i <= aoeMaxCnt; i++) { // 遍历是从0到aoeMaxCnt闭区间！
            // 分别计算剩余血量
            int ta = a - i * y;
            int tb = b - i * y;

            // 这里不能无脑添加，因为由于aoeMaxCnt是根据最大的计算的，所以这里ta或者tb完全有可能为负数，即已经死了
            // 这就会导致算的单体技能的使用次数反而减少，显然错误；总而言之，死亡的怪物不需要再放技能！
            int singleA = ta > 0 ? (int) Math.ceil(ta / (double) x) : 0;
            int singleB = tb > 0 ? (int) Math.ceil(tb / (double) x) : 0;

            ans = Math.min(ans, i + singleA + singleB);
        }
        System.out.println(ans);
    }
}
