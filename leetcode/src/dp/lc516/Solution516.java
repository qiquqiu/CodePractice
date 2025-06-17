package dp.lc516;

public class Solution516 {
    // 最长回文子序列
    public int longestPalindromeSubseq(String s) {
        // dp[i][j] 表示下标i和j之间的序列中最长回文子序列的长度(0表示不含回文子序列)
        // dp[i][j] = dp[i + 1][j - 1] + 2
        int len = s.length();
        char[] str = s.toCharArray();
        int maxLen = 1;
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                if (str[i] == str[j]) {
                    if (i + 1 < len && j - 1 >= 0) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    if (i + 1 < len && j - 1 >= 0) {
                        // 要明白如果str[i] != str[j] 那么i j之间想要构成回文子序列
                        // 必须是str[i]和str[j]中“有且只有一个”能和i+1 j-1序列构成回文子序列
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                }
                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                }
            }
        }
        return maxLen;
    }
}
