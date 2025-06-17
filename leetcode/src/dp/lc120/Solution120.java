package dp.lc120;

import java.util.List;

public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 与前面几题一样可以看成矩阵
        // dp[x][y] = min(dp[x - 1][y -1], dp[x - 1][y]) + tri[x][y];
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[triangle.get(i).size()];
        }
        dp[0][0] = triangle.get(0).get(0);
        int x = 0, y = 0;
        for (int i = 1; i < n; i++) {
            List<Integer> curLine = triangle.get(i);
            int j;
            for (j = 0; j < curLine.size(); j++) {
                // 状态转移方程没错，要注意数组形态的设定和条件判断控制
                if (j - 1 >= 0 && j < dp[i - 1].length) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + curLine.get(j);
                } else {
                    if (j - 1 < 0) {
                        dp[i][j] = dp[i - 1][j] + curLine.get(j);
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + curLine.get(j);
                    }
                }
            }
        }
        int[] lastLine = dp[n - 1];
        int min = lastLine[0];
        for (int i : lastLine) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
}
