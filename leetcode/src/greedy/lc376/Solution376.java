package greedy.lc376;

public class Solution376 {
    // 这种思路的最原始的解法：相当于没有对任何特殊情况做合并
    // https://leetcode.cn/problems/wiggle-subsequence/description/comments/1329757


    // [1, 2]、[2] 这种情况的ans为1、2，也算摆动序列
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int ans = 1, prevDiff = 0;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1]; // 当前差值
            if ((diff > 0 && prevDiff <= 0) || (diff < 0 && prevDiff >= 0)) {
                ans++;
                prevDiff = diff;
            }
        }
        return ans;
    }

    // 试试动态规划（优化后的），太妙了！
    // https://chatgpt.com/share/674156a8-919c-800a-a0c1-3d632e12a0d0
    public int wiggleMaxLength2(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int up = 1;   // 表示以当前元素为结尾，最后一个摆动为“上升”的序列长度
        int down = 1; // 表示以当前元素为结尾，最后一个摆动为“下降”的序列长度

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1; // 如果上升，更新 up
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1; // 如果下降，更新 down
            }
        }
        return Math.max(up, down);
    }

}