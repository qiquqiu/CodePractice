package unclassified.lc459;

public class Solution459 {
    // 方法一：暴力解法 O(n^2) 2427ms/1656ms，5%击败
    public boolean repeatedSubstringPattern(String s) {
        char[] cs = s.toCharArray();
        // i表示每轮截取的从头开始的子串的最右方下标
        for (int i = 0; i < cs.length; i++) {
            String std = new String(cs, 0, i + 1);
            int j = i + 1;
            // 优化后
            if ((cs.length - i - 1) % (i + 1) == 0) {
                // 不是倍数关系直接跳
                while (j + i < cs.length && std.equals(new String(cs, j, i + 1))) {
                    j += i + 1;
                }
            } else {
                continue;
            }
            if (j == cs.length && !std.equals(s)) {
                return true;
            }
        }
        return false;
    }
}
