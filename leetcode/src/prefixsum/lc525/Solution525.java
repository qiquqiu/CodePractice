package prefixsum.lc525;

import java.util.Arrays;
import java.util.HashMap;

public class Solution525 {
    public int findMaxLength(int[] nums) {
        // 由于题目值的特殊性，前缀和数组中的一个值，可以同时表示该前缀区间所有的0的个数和1的个数
        int len = nums.length;
        if (len == 2) {
            return nums[0] == nums[1] ? 0 : 2;
        }
        int[] pre = new int[len];

        // 可以重新审题，重新利用1、0的特性，可以把数组所有的0原地变为-1
        // 这样后续只需要找原数组中区间和为0的最大长度即可，即便不知道后续可能带来什么更简单的简化
        // 但是就单单把从需要根据值和索引来判断区间是否“符合”变为了仅需要判断区间和是否为0这一个条件的大大简化了
        for (int i = 0; i < len; i++) {
            nums[i] = nums[i] == 0 ? -1 : 1;
            if (i == 0) {
                pre[i] = nums[0];
            } else {
                pre[i] = pre[i - 1] + nums[i];
            }
        }
        System.out.println(Arrays.toString(pre));

        // 遍历数组，找出最长区间;不用求区间，只求最大长度即可;初始为0
        int maxLen = 0;

        // 在优化结构之后的前缀和数组，只需要关注相同值出现的间距的最大值即可！
        HashMap<Integer, Integer> map = new HashMap<>();

        // 如果要用这种思路以及这种结构的前缀和，这也是一个特殊情况！
        // 默认-1索引处前缀和为0，后面再遇到前缀和为0的可以直接计算它而不找一个存在数组中的前缀和为0的
        // 总之，前缀和为0的这个键值对特殊，它是总是必然存在的且是第一个键值！
        map.put(0, -1);

        // 遍历前缀和数组
        for (int i = 0; i < len; i++) {
            if (map.containsKey(pre[i])) {
                // 如果前缀和已经存在，计算距离并更新最大长度
                maxLen = Math.max(maxLen, i - map.get(pre[i]));
            } else {
                // 如果前缀和不存在，存储索引
                map.put(pre[i], i);
            }
        }

        return maxLen;

        /*// 直接遍历找符合的时间超时了
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                // 计算区间[i, j]之间是否是0、1数量相等
                // 先求[i, j]之间的值的和
                int sum;
                if (i - 1 >= 0) {
                    sum = pre[j] - pre[i - 1];
                } else {
                    sum = pre[j];
                }
                // 闭区间元素个数: j-i+1
                if ((j - i + 1) % 2 == 0 && sum == (j - i + 1) / 2) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;*/
    }
}
