package twopointer._01slidingwindow.fixed.lc1052;

/**
 * 思路正确，还是定长滑动窗口，与上题类似，做了些变化
 */
public class Solution {
    // 思路，要让收益最高，就要把这“强制令min分钟的顾客满意”的作用发挥到最大
    // 也就是更新滑动窗口找最大窗口的时候不仅仅要考量窗口和值，还要考虑原先是什么
    // 可以这样计算收益：收益为窗口中1（不满意）的顾客数量之和
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0, len = customers.length, addAns = -1, tempSum = 0, l = 0;
        for (int i = 0; i < len; i++) {
            // 先把没生气的所有必定会要的基础答案添加
            ans += grumpy[i] == 1 ? 0 : customers[i];
        }
        // 找“收益最大”的窗口
        for (int i = 0; i < minutes; i++) {
            tempSum += grumpy[i] == 1 ? customers[i] : 0;
        }
        for (int r = minutes; r < len; r++, l++) {
            addAns = Math.max(addAns, tempSum);

            tempSum -= grumpy[l] == 1 ? customers[l] : 0;
            tempSum += grumpy[r] == 1 ? customers[r] : 0;
        }
        addAns = Math.max(addAns, tempSum);
        return ans + addAns;
    }
}
