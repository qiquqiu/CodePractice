package hashtable.lc454;

import java.util.HashMap;
import java.util.Map;

public class Solution454_2 {
    // Solution454 的优化，时间复杂度上没有变化，但是执行时间变短了；空间复杂度也降低了
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int cnt = 0; // 记录结果组数
        Map<Integer, Integer> map_ab = new HashMap<>();

        for (int a : nums1) {
            for (int b : nums2) {
                map_ab.put(a + b, map_ab.getOrDefault(a + b, 0) + 1);
            }
        }

        for (int c : nums3) {
            for (int d : nums4) {
                if (map_ab.containsKey(-(c + d))) {
                    cnt += map_ab.get(-(c + d));
                    // 即：+= map_ab.get(-(c + d))) * 1
                }
            }
        }
        return cnt;
    }
}
