package lq_13_java_b;

public class Main2 {
    // 给了差不多20亿的范围，暴力实在是没有活路;
    // 直接整个暴力时间太长了，算法本身没问题，但是看起来像死循环，考试机器可能更垃圾，所以基本不可能全段暴力
    // 这里选择分区分位数暴力，得出各个区段的结果。
    // 4:36;5:165;6:165;7:495;8:495;9:1287;10:1782
    public static void main(String[] args) {
        int cnt = 0;
        for (int i = 100000000; i <= 2022222022; i++) {
            if (isLikeMount(i)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static boolean isLikeMount(long num) {
        String s = String.valueOf(num);
        int n = s.length();

        // 检查回文
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }

        // 检查前半部分非递减
        for (int i = 0; i < /*len*/(n + 1) / 2 - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }


}
