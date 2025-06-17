package dp.lc931;

public class Solution931 {
    public int minFallingPathSum(int[][] matrix) {
        // dp[x][y] = min(dp[x - 1][y - 1], min(dp[x - 1][y], dp[x - 1][y + 1])) + matrix[x][y]
        // dp[x][y]表示matrix数组中到达xy处的最小路径和
        // O(n^2)的时间复杂度有点偏高了；最直观的思路就是由于每个位置都是可以到达的，所以索性计算每个位置的最小路径和
        int n = matrix.length;
        int[][] dp = new int[n][n];
        dp[0] = matrix[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j - 1 < 0 && j + 1 < n) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
                } else if (j - 1 >= 0 && j + 1 >= n) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
                } else if (j - 1 >= 0 && j + 1 < n) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + matrix[i][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + matrix[i][j];
                }
            }
        }
        int minVal = dp[n - 1][0];
        for (int i : dp[n - 1]) {
            if (i < minVal) {
                minVal = i;
            }
        }
        return minVal;
    }
}
