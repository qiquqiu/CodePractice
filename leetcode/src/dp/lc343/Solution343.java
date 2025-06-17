package dp.lc343;

public class Solution343 {
    // 整数拆分求最大积问题
    public int integerBreak(int n) {
        // dp[n] 就表示将n进行拆分相乘所能得到的最大值
        int[] dp = new int[n + 1]; // dp[0] dp[1] dp[2] 比较特殊手动赋值
        dp[2] = 1;
        // 分析：易知，从4开始（包含）拆就一定是大于等于不拆
        // 所以，如果将i拆分为两个数，结果为 j * (i - j)
        // 如果将i拆分为大于等于三个数，结果为 j * dp[i - j] （状态转移）
        // 显然j是内部的遍历从1到i，而结合“dp[i - j]”所以说求dp[i]会用上前面的值，所以说i是从1到n遍历
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(j * (i - j), j * dp[i - j]), dp[i]);
            }
        }
        return dp[n];
    }
}
