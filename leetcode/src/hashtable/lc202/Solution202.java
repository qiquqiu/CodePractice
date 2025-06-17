package hashtable.lc202;

import java.util.HashSet;
import java.util.Set;

public class Solution202 {
    // 哈希表法
    // 判断一个数是否是开心数（关键在于想到要使用哈希表）
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int res = n;
        while (true) {
            set.add(res);
            res = deal(res);
            if (res == 1) {
                return true;
            }
            if (set.contains(res)) {
                return false;
            }
        }
    }

    public int deal(int n) {
        // 这里循环for换成while(n > 0)去掉Line26可以提高一些速度
        int weishu = (n + "").length();
        int sum = 0;
        for (int i = weishu - 1; i >= 0; i--) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
