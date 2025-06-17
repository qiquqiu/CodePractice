package hashtable.lc347;

import java.util.*;

public class Solution347 {
    // 一眼哈希,时间复杂度O(n) + O(n) + O(n log n) + O(k) = O(n log n)
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        // 键：元素值，值：元素出现次数
        Map<Integer, Integer> map = new HashMap<>();

        // O(n)
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        // O(nlogn)
        list.sort((o1, o2) -> {
            return Integer.compare(o2.getValue(), o1.getValue()); // 降序
        });

        // O(k)
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }

        return res;
    }
}
