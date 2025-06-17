package dp.lc05;

public class Solution05_dp1 {
    public String longestPalindrome(String s) {
        // dp[i][j] 表示i、j索引之间的子串是否是回文子串
        int len = s.length();
        char[] str = s.toCharArray();
        int left = 0, right = 0, size = 0;
        int[][] dp = new int[len][len];

        // 需要修改遍历顺序为从下到上，从左到右遍历！！！
        // 因为我们在使用递推逻辑的时候要用上dp[i + 1][j - 1]的信息
        // 如果正常顺序来遍历的话，这个信息许多都是尚未知的
        // 而虽然我们通过两个下标表示范围起始，但是dp总归是个二维数组
        // 想要总是知道dp[i + 1][j - 1]的信息，我们就要让i是从大到小，j是从小到大
        // 这样才总是能够知道第i+1行第j-1列的数组值
        // ---关键：下标与问题意义的紧密结合和遍历时候结合需求做出的调整---
        // 从这里我们也学到了遍历字符串不止一种O(n^2)遍历方式，有多种方式！
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                if (i + 1 == j) {
                    dp[i][j] = str[i] == str[j] ? 1 : 0;
                } else if (dp[i + 1][j - 1] == 1 && str[i] == str[j]) {
                    dp[i][j] = 1;
                }
                // 更新的条件别弄错了，dp为0的时候不更新！！！
                if (j - i > right - left && dp[i][j] == 1) {
                    left = i;
                    right = j;
                }
            }

        }
        return s.substring(left, right + 1);
    }
}
