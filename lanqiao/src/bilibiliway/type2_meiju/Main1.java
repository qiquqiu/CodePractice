package bilibiliway.type2_meiju;

import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P10424
 * 填空类题，初步判断为枚举类型
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        // 计算1到n之间的“好数”的个数之和
        for (int i = 1; i <= n; i++) {
            ans = isGoodNum(i) ? ans + 1 : ans;
        }
        System.out.println(ans);
    }

    // 从低位（个位）开始算，奇数位全为奇数，偶数位全为偶数
    public static boolean isGoodNum(int n) {
        // 非本地获取答案然后天空题，素以需要做一些优化，不能无脑转String遍历
        int flag = 1;
        while (n != 0) {
            // 循环获取n的从个位开始的奇数偶数位
            int digit = n % 10;
            if (flag % 2 == 1) {
                if (digit % 2 == 0) {
                    return false;
                }
            } else {
                if (digit % 2 == 1) {
                    return false;
                }
            }
            n /= 10;
            flag++;
        }
        return true;
    }
}
