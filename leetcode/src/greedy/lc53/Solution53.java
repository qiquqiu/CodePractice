package greedy.lc53;

import java.util.*;

public class Solution53 {
    // 首先试试前缀和，直接做的话显然跟dp一样是O(n^2)
    // 不出意外最后几个例子确实超时了
    public int maxSubArray1(int[] arr) {
        int len = arr.length;
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + arr[i];
        }
        System.out.println(Arrays.toString(preSum));
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                max = Math.max(max, preSum[j + 1] - preSum[i]);
            }
        }
        return max;
    }

    // 真正的局部最优，即局部和最大
    // 关注点是连续和！！！
    public int maxSubArrayGreedy(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int ans = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > ans) {
                // 能够使得连续和变大就更新
                // 不能够使得连续和变大也加上
                ans = sum;
            }
            // 使得连续和为负数了，那么就重新从下一个开始计算连续和
            if (sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }

    // 再正确的动态规划的解法：由于时间复杂度不能是O(n^2)，所以dp数组只能是一位数组
    public int maxSubArrayDP(int[] arr) {
        // dp[i] 包含到以arr[i]结尾的数组的最大连续和
        // 跟贪心的思路有点类似，要么加上一个，要么重新开始计算
        // 状态转移方程 dp[i] = Math.max(dp[i - 1] + arr[i], arr[i])
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int ans = dp[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            // 更新最大连续和
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    // 因为dp[i]的递推公式只与前一个值有关，所以可以用一个变量代替dp数组，空间复杂度为O(1)
    public int maxSubArrayDP2(int[] arr) {
        int pre = arr[0];
        int ans = pre;
        for(int i = 1; i < arr.length; i++) {
            pre = Math.max(pre + arr[i], arr[i]);
            ans = Math.max(ans, pre);
        }
        return ans;
    }

    /*
     * 首先我自己思考我感觉可能要用类似滑动窗口的方式
     * 所谓的局部最优，就是每次遍历让右指针右移开始前进：
     * 1.如果加上下一个会导致sum变大（0不影响），则加上它
     * 2.如果加上下一个会导致sum变小，则不加它并且记下未加之前的sum，然后左右指针同时移动到
     *   该数右边第一个继续遍历...
     * 有效的窗口范围是：[l, r]，但是实际代码不需要left
     *
     * 这种滑动窗口的 2. 处的逻辑是有问题的！
     * */
    // 错误的原因：还是没有确定好真正正确的“局部最优”！
    @Deprecated
    public int maxSubArrayGreedyFailed(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        int len = arr.length, r = 1, ans = Integer.MIN_VALUE, sum = arr[0];
        while (r < len) {
            if (sum + arr[r] >= sum) {
                sum += arr[r];
                r++;
            } else {
                sum = Math.max(sum, arr[r]);
                ans = Math.max(ans, sum);
                sum = 0;
                r++;
            }
        }
        return ans;
    }
}
