package dp.lc221;

public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        // dp[i][j]表示以i、j下标行列处为正方形右下角的时候所构成的该正方形的最大边长
        // dp[i][j] = min(dp[i - 1][j - 1], min(dp[i - 1][j], dp[i][j - 1])) + 1
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    } else {
                        dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                    }
                    maxArea = Math.max(maxArea, dp[i][j] * dp[i][j]);
                }
            }
        }
        return maxArea;
    }
}
