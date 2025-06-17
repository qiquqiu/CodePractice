package twopointer._01slidingwindow.fixed.lc1423;

/**
 * 也是定长滑动窗口，但是和前面几个相比没有那么显然
 * 此题是逆向思维，并且应当不难想到，反正由数据量的提示，暴力、dfs必定超时
 */
public class Solution {
    // 因为要从两边选定长k个，遍历所有选的情况，余留下来的那些数组序列恰好就是定长为n-k的窗口的所有轨迹
    public int maxScore(int[] arr, int k) {
        int ans = Integer.MAX_VALUE, l = 0, windowSum = 0, sum = 0, n = arr.length;
        for (int i = 0; i < n - k; i++) {
            sum += arr[i];
            windowSum += arr[i];
        }
        // 对窗口而言，余留的要取最大，即窗口要找最小值（因为数组总和一定）
        for (int r = n - k; r < n; r++) {
            sum += arr[r];
            ans = Math.min(ans, windowSum);

            windowSum -= arr[l++];
            windowSum += arr[r];
        }
        // 遇上一题一样，当最佳窗口在最右边时，最后需要保底更新一次
        ans = Math.min(ans, windowSum);
        return sum - ans;
    }
}
