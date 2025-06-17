package hashtable.lc01;

import java.util.HashMap;
import java.util.Map;

public class Solution01 {
    // 哈希表法解决，核心思路：元素是否曾出现过（所以说元素是key）
    public int[] twoSum(int[] nums, int target) {
        // 数组的值为key，索引为value，有重复的key不用更新value
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i]; // 差值
            if (map.containsKey(sub)) { // 若差值曾出现过（首次出现会被添加进map）
                res[0] = map.get(sub);
                res[1] = i;
            } else { // 否则首次出现就添加（若出现过num[i]，那么这里将根据key更新其value值）
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
