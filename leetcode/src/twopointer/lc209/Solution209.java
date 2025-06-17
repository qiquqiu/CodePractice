package twopointer.lc209;

public class Solution209 {
    // 滑动窗口法
    // 此题的滑动窗口得益于元素非负，右指针向右一定增加总和，左指针向右一定减少总和
    // 关于时间复杂度是O(n)的理解;
    // 每个元素在滑动窗后进来操作一次，出去操作一次，每个元素都是被操作两次
    // 所以时间复杂度是 2 × n 也就是O(n)
    // 或者这样理解：整体上看实际上就是两个单向移动的指针在遍历整个数组，
    // 既然是单向则肯定是n，那么两个指针就是2n...
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0, sum = 0, subLen = 0;
        // 注意，res第一次必须是最大值，因为必须“不影响第一次res取值”
        int res = nums.length + 1;
        // right总是指向窗口的右终点
        while (right < nums.length) {
            // 一旦right移动了就总是先计算新窗口的总和大小
            sum += nums[right];
            // 这里用while而非if，就是希望达到这样的效果
            // 当在当前的left下第一次遇到了可行的窗口之后
            // 保存、更新长度之后，总是先循环地不断使left++
            // 即从左边缩小窗口的大小，来进一步确定当前right下
            // 的最小解！（不然如果继续right直接++的话，显然sum就
            // 更大了，无法确定最小解），然后直到当前right情况下最小解
            // 确定之后，才让right继续向后移动，而left就保持在其已经移动
            // 之后的位置就可以了，不用也不能重置，因为显然我们一次遍历
            // 窗口只能通过right扩大，通过left缩小
            while (sum >= s) {
                // 若满足条件 ：大于等于s
                // 则先保存当前长度
                subLen = right - left + 1;
                // 总是取上次结果res与当前长度的最小者
                // 即更新res
                res = Math.min(res, subLen);
                sum -= nums[left];
                left++;
            }
            // 出while循环就是找到了当前right的最小res解并已经保存了
            // 那么向后继续即可
            right++;
        }
        // 若res最终还是初始的不可能在有解的情况取到的值，则返回0
        return res == nums.length + 1 ? 0 : res;
    }
}
