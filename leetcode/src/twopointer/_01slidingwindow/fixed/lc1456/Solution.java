package twopointer._01slidingwindow.fixed.lc1456;

/**
 * O(n)
 */
class Solution {
    public int maxVowels(String s, int k) {
        int l = 0, cur = 0, ans = 0;
        char[] arr = s.toCharArray();
        int len = arr.length;

        for (int i = 0; i < k; i++) {
            if (check(arr[i])) {
                cur++;
            }
        }

        for (int r = l + k; r < len; r++, l++) {
            // 定长向右滑动
            if (check(arr[l])) {
                // 每次将要减少前维护一下大的值
                ans = Math.max(cur, ans);
                cur--;
            }
            if (check(arr[r])) {
                cur++;
            }
        }

        // 防止一直递增的情况导致最后没有机会在递减处维护到，所以单独一次max
        return Math.max(cur, ans);
    }

    public boolean check(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}