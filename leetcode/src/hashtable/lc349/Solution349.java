package hashtable.lc349;

import java.util.HashSet;
import java.util.Set;

public class Solution349 {
    // 求两个数组的交集（这里的交集就是数学集合意义上的交集）
    // 显然使用哈希表实现，另外，数据范围已知，其实可以使用数组来自己模拟哈希表
    // 以下方法示例虽然使用了哈希表但是也算一种比较暴力的哈希表使用

    // 有很多地方可以优化：例如hash1和hash2可以同时获取，即遍历Math.min(len1, len2)
    // 的次数，再对还有剩余的数组进行遍历，这样就可以许多遍历次数
    // 另外最后判断两个哈希表是否匹配也可以只遍历Math.min(len1, len2)次

    // 甚至最后可以使用hash1.retainAll(hash2)来快速得到交集
    // hash1 在调用 retainAll(hash2) 后只保留了它与 hash2 的交集，而 hash2 保持不变
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hash1 = new HashSet<>();
        Set<Integer> hash2 = new HashSet<>();
        int len1 = nums1.length, len2 = nums2.length, index = 0;
        int[] res = new int[Math.max(len1, len2)];
        for (int val : nums1) {
            hash1.add(val);
        }
        for (int val : nums2) {
            hash2.add(val);
        }
        for (int val : hash1) {
            if (hash2.contains(val)) {
                res[index++] = val;
            }
        }
        int[] result = new int[index];
        for (int i = 0; i < index; i++) {
            result[i] = res[i];
        }
        return result;
    }
}
