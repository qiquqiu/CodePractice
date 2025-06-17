package twopointer._02binary.lc2529;

/**
 * O(log n)
 * 不过这由于算是简单题，单个数组长度最长也才2000，即便是O(n)亦可，甚至O(n)也很好优化，大部分情况不需要遍历完全
 */
class Solution {
    // 显然两个思路，一个思路是线性遍历数量相当于线性查询（可以优化到遇到分界就停止，但是仍接近O(n)）
    // 另一个思路是找到正负数分界线，例如找第一个（最小）正数

    // 其实直接找第一个正数/负数是不好利用而非规则的
    // 可以将问题转为：求最大的比0小的数的索引和最小的比0大的数的索引，没有则返回-1，这就回到了之前标准模板了
    // 0就是target
    public int maximumCount(int[] arr) {
        int len = arr.length;
        if (arr[0] >= 0) {
            int i = 0;
            while (i < arr.length && arr[i] == 0) {
                len--;
                i++;
            }
            return len;
        }
        if (arr[len - 1] <= 0) {
            int i = len - 1;
            while (i >= 0 && arr[i] == 0) {
                len--;
                i--;
            }
            return len;
        }

        int l = 0, r = len - 1, ans1 = -1, ans2 = -1, mid;
        // 找最大的比target小的索引
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] >= 0) {
                r = mid - 1;
            } else {
                ans1 = mid;
                l = mid + 1;
            }
        }
        l = 0;
        r = len - 1;
        // 找最小的比target大的索引
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] <= 0) {
                l = mid + 1;
            } else {
                ans2 = mid;
                r = mid - 1;
            }
        }
        // 总共四种特殊情况，前面提前处理了全正全负的，还有正常和全0的
        return ans1 == -1 && ans2 == -1 ? 0 /* 全0 */ : Math.max(ans1 + 1, arr.length - ans2);
    }
}