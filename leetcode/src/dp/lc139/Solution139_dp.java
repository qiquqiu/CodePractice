package dp.lc139;

import java.util.HashSet;
import java.util.List;

public class Solution139_dp {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        // dp[i] 表示s中从头开始的长度为i的(子)串是否在字典中出现过
        dp[0] = true; // 题目保证s长度至少为1，所以dp[0]不会影响
        // dp[0] 的作用就是给后面用于递推
        // 状态转移方程： dp[i] = dp[j] && set.contains(s.substring(j, i + 1)) （j < i）
        // 适当再引入第二个变量，将问题抽象到最直观直接的步骤
        for (int i = 1; i <= len; i++) { // 经调试这里的等号勿忘记
            for (int j = 0; j < i; j++) {
                dp[i] = dp[j] && set.contains(s.substring(j, i));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[len];
    }
}
