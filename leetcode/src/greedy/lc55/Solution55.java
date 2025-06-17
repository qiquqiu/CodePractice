package greedy.lc55;

public class Solution55 {
    // 初步通过率 171/173
    // 失败用例：[4,2,0,0,1,1,4,4,4,0,4,0]
    // 不过大体思路是对的，局部最优解就是本次要在力所能及之内要跳到最远点
    public boolean canJump(int[] nums) {
        int i = 0;
        int maxCover = 0;
        // 注意，这里遍历范围一定是在能够覆盖范围之内，不能直接遍历所有，不然遇到一些0的情况，不符合本循环内的处理逻辑
        while (i <= maxCover) {
            // 直接一步跳到当前位置的最大范围处，而不是跳到当前所能跳到的具有最大步数的点处
            // 无需为下一步做考虑，保证局部最优，即本次最优即可！
            if (maxCover >= nums.length - 1) {
                return true;
            }
            maxCover = Math.max(maxCover, i + nums[i]);
            // 不能真正的直接跳跃，要每个遍历！！！因为这样才能找到最大覆盖范围
            // 同时maxCover，即循环条件又是动态调整的！因为所有能达到的点都要遍历看是否有更大范围

            // 如果是{2, 0, 0, 0, 3, 1}，这种由0阻塞的问题，那么由于cover不能得到更新，会结束循环返回false
            i++;
        }
        return false;
    }

    // 需要遍历的话，直接维护最大高度，对于return false的情况特殊处理
    public boolean canJump2(int[] nums) {
        int maxCover = 0;
        for (int i = 0; i < nums.length; i++) {
            maxCover = Math.max(maxCover, nums[i] + i);

            // 就是用于处理到非末尾且非范围内的边界0的情况！
            // 不能直接显示处理if(nums[i]==0...) 因为有的0可能也是在范围内的
            // 只有对于非末尾且非范围内的边界0时候才是再也无法跳了！ {2, 0, 0, 0, 3, 1}
            if (i == maxCover && i != nums.length - 1) {
                return false;
            }
        }
        return true;
    }
}