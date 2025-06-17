package twopointer._01slidingwindow.fixed.lc2841;

import java.util.HashMap;
import java.util.List;

class Solution {
    public long maxSum(List<Integer> list, int m, int k) {
        // 定长滑动窗口，长度为k，涉及到“不相同”元素，可使用哈希表
        HashMap<Integer, Integer> map = new HashMap<>(); // 值--->窗口中出现的次数
        long sum = 0, ans = 0; // tips：和得使用long
        for (int i = 0; i < k; i++) {
            // 先初始化第一个k长度区间
            int num = list.get(i);
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        if (map.size() >= m) {
            ans = sum;
        }

        for (int r = k, l = 0; r < list.size(); r++, l++) {
            // 移动得到新的开始的窗口
            int leftVal = list.get(l);
            int rightVal = list.get(r);

            // 更新窗口对应的哈希表
            if (map.get(leftVal) == 1) {
                // 只有舍弃的左端点仅仅只有一次才删键
                map.remove(leftVal);
            } else {
                map.put(leftVal, map.get(leftVal) - 1);
            }
            map.put(rightVal, map.getOrDefault(rightVal, 0) + 1);

            sum -= leftVal;
            sum += rightVal;

            // 再判断是不是“唯一子数组”：（维护的窗口的哈希表的键的数量>=m）
            if (map.size() >= m) {
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}