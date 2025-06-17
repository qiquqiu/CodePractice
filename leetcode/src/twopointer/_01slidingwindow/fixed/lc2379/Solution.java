package twopointer._01slidingwindow.fixed.lc2379;

/**
 * 定长滑动窗口
 */
class Solution {
    public int minimumRecolors(String blocks, int k) {
        char[] arr = blocks.toCharArray();
        int cnt = 0, l = 0, ans;
        for (int i = 0; i < k; i++) {
            cnt = arr[i] == 'W' ? cnt + 1 : cnt;
        }

        ans = cnt;

        for (int r = k; r < arr.length; r++) {
            cnt = arr[l++] == 'W' ? cnt - 1 : cnt;
            cnt = arr[r] == 'W' ? cnt + 1 : cnt;

            ans = Math.min(ans, cnt);
        }

        return ans;
    }
}