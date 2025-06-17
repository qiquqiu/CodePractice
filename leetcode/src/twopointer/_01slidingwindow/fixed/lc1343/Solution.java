package twopointer._01slidingwindow.fixed.lc1343;

/**
 * 和上一题类似，也是定长窗口
 */
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int len = arr.length, l = 0, ans = 0, sum = 0;
        // 长度为k的窗口，和上一题思路几乎一样

        // 先把第一次的算出来后面的for循环更好理解
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        ans = sum / k >= threshold ? 1 : 0;

        for (int r = k; r < len; r++) {
            sum -= arr[l++];
            sum += arr[r];

            ans = sum / k >= threshold ? ans + 1 : ans;
        }

        return ans;
    }
}