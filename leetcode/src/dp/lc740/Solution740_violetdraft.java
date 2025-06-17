package dp.lc740;

public class Solution740_violetdraft {
    public int deleteAndEarn(int[] nums) {
        // ！！！理解错题意了，此处报废，所以还是动态规划的递推！！！

        // 普通暴力的话是O(n^2)的时间复杂度，使用哈希表优化后可以强行降为O(n)
        // ret[i] = nums[i] + ∑(nums[i] - 1) + ∑(nums[i] + 1)
        int[] hash = new int[20000];
        int[] ret = new int[nums.length];
        for (int num : nums) {
            hash[num]++;
        }
        for (int i = 0; i < ret.length; i++) {
            ret[i] = nums[i] + (nums[i] - 1) * hash[nums[i] - 1] + (nums[i] + 1) * hash[nums[i] + 1];
        }
        int max = ret[0];
        for (int r : ret) {
            if (r > max) {
                max = r;
            }
        }
        return max;
    }
}
