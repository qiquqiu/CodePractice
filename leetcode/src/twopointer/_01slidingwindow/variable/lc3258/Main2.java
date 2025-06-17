package twopointer._01slidingwindow.variable.lc3258;

/**
 * 滑动窗口：O(n)
 * 初始的错误解法，没有注意到，一旦通过滑动窗口得到一个合法窗口情况后，应当统计的不止是当前完全窗口的一种情况
 * 而应当是窗口内以所枚举的右端点开始的所有子窗口均满足
 */
public class Main2 {
    public int countKConstraintSubstrings(String s, int k) {
        int ans = 0, l = 0;
        char[] arr = s.toCharArray();
        int[] cnt = new int[2]; // cnt[0], cnt[1]
        for (int r = 0; r < arr.length; r++) {
            cnt[arr[r] - '0']++;
            // 通过滑动窗口长度得到合法的个数（枚举右端点，左端点右移找到合法的即可以得出）
            while (cnt[0] > k && cnt[1] > k) {
                cnt[arr[l++] - '0']--;
            }
            // 找到一个符合区间
            ans += r - l + 1;
        }
        return ans;
    }

//    public static void main(String[] args) {
//        System.out.println(new Main2().countKConstraintSubstrings("10101", 1));
//    }
}
