package hashtable.lc454;

import java.util.HashMap;
import java.util.Map;

public class Solution454 {
    // 哈希表思想
    // 思路概括：类似于lc01，可以降维转换为与之类似的两数之和的问题
    // 只不过这里的键值所指有所变化，这里我们先遍历AB数组，在各取出一个数的情况下
    // 得到AB数组的两数之和a+b的值的所有情况，将这些值作为key，而value则为当前key在
    // AB两个数组中可以组合出的对数；然后在同理对数组CD中同样操作，最后遍历比对
    // 由乘法原理相乘即得最终情况的组数,返回之
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int cnt = 0; // 记录结果组数
        Map<Integer, Integer> map_ab = new HashMap<>();
        Map<Integer, Integer> map_cd = new HashMap<>();

        setMap(nums1, nums2, map_ab);
        setMap(nums3, nums4, map_cd);

        for (Map.Entry<Integer, Integer> entry : map_ab.entrySet()) {
            int key = entry.getKey();
            if (map_cd.containsKey(-key)) {
                cnt += entry.getValue() * map_cd.get(-key);
            }
        }
        return cnt;
    }

    private void setMap(int[] nums1, int[] nums2, Map<Integer, Integer> map) {
        // 不可避免的O(n^2)
        for (int c : nums1) {
            for (int d : nums2) {
                int key = c + d;
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    map.put(key, map.get(key) + 1);
                }
            }
        }
    }
}
