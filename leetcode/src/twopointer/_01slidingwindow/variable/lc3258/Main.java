package twopointer._01slidingwindow.variable.lc3258;

/**
 * 暴力
 */
public class Main {
    public int countKConstraintSubstrings(String s, int k) {
        int ans = 0;
        char[] arr = s.toCharArray();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (check(arr, i, j, k)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public boolean check(char[] arr, int begin, int end, int k) {
        int cnt0 = 0, cnt1 = 0;
        for (int i = begin; i <= end; i++) {
            int b = arr[i] == '0' ? cnt0++ : cnt1++;
        }
        return cnt0 <= k || cnt1 <= k;
    }
}
