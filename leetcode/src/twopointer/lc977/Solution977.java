package twopointer.lc977;

public class Solution977 {
    // 双指针题型
    // 最开始的双指针的思路是没有问题的，就是实现的时候有点问题
    // 此时还仅仅只能够处理“负数-（0）-正数”的输入，不能处理“负数-负数-负数”的输入
    // 需要进行if-else处的调整，这点与“归并排序”的比较方式有点类似
    public int[] sortedSquares(int[] nums) {
        int[] temp = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        while (left <= right) {
            int a = nums[left] * nums[left];
            int b = nums[right] * nums[right];
            if (a >= b) {
                temp[index--] = a;
                left++;
            } else {
                temp[index--] = b;
                right--;
            }
        }
        return temp;
    }
}
