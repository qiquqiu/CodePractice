package twopointer._01slidingwindow.fixed.lc643;

/**
 * 定长滑动窗口
 */
class Solution {
    public double findMaxAverage(int[] arr, int k) {
        int len = arr.length, l = 0, ans = 0, sum = 0;
        // 长度为k的窗口，和上一题思路几乎一样
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        ans = sum;
        for (int r = k; r < arr.length; r++) {
            sum -= arr[l++];
            sum += arr[r];

            ans = Math.max(ans, sum);
        }

        return ans / (double) k;
    }
}