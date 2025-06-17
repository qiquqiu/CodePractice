package twopointer._01slidingwindow.fixed.lc2461;

import java.util.HashMap;
import java.util.Map;

/**
 * 定长滑动窗口+哈希去重
 */
public class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        // 维护窗口中值与出现次数
        Map<Integer, Integer> map = new HashMap<>();
        int len = arr.length, l = 0;
        long ans = 0, sum = 0; // 得用long
        if (len < k) {
            return 0;
        }

        for (int i = 0; i < k; i++) {
            sum += arr[i];
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int r = k; r < len; r++, l++) {
            if (map.size() == k) {
                ans = Math.max(ans, sum);
            }

            sum += arr[r];
            sum -= arr[l];

            int leftCnt = map.get(arr[l]);
            if (leftCnt == 1) {
                map.remove(arr[l]);
            } else {
                map.put(arr[l], leftCnt - 1);
            }
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
        }

        // 当最佳窗口在最右边时，最后需要保底更新一次
        if (map.size() == k) {
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}