package dp.lc70;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution70 {
    // 数学题罢了
    // 经过把所有点输出来，手搓所有结果，n=35的结果是对的
    // 这个方法的问题在于阶乘数据的溢出！
    public int climbStairs(int n) {
        List<List<Integer>> points = new ArrayList<>();
        int x, ans = 0;
        // 遍历y而非x，好处1可以避免小数、2可以减少一半工作量
        for (int i = 0; i <= n / 2; i++) {
            x = n - 2 * i;
            points.add(Arrays.asList(x, i));
            if (x == 0 || i == 0) {
                ans++;
            } else {
                ans += fac(x + i) / fac(x) * fac(i);
            }
        }
        System.out.println("point集合(共有" + points.size() + "个点)");
        System.out.println(points);
        return ans;
    }

    // 求n的阶乘
    public int fac(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fac(n - 1);
    }
}