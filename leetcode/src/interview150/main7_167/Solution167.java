package interview150.main7_167;

public class Solution167 {
    // 两数之和Ⅱ，且规定使用O(1)的空间复杂度
    // 本代码时间复杂度 O(Nlogn)，空间复习度 O(1)
    public int[] twoSum(int[] arr, int target) {
        // 题目有保障：arr数组是非递减排列的；结合两数之和查找法，可以使用二分查找
        for (int i = 0; i < arr.length; i++) {
            int div = target - arr[i];

            // 成功的时候，divIndex必然是在i的右边的
            int divIndex = binarySearch(arr, i + 1, arr.length - 1, div);

            if (divIndex != -1) {
                return new int[]{i + 1, divIndex + 1};
            }
        }
        // 题目保障存在答案，必然会在for内返回
        return null;
    }

    // 在非递减数组 arr 的 [left, right] 范围内查找 target 的索引
    public int binarySearch(int[] arr, int left, int right, int target) {
        // 检查输入参数的有效性
        if (arr == null || arr.length == 0 || left < 0 || right >= arr.length) {
            return -1;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid; // 找到目标值，返回索引
            } else if (arr[mid] < target) {
                left = mid + 1; // 目标值在右半部分
            } else {
                right = mid - 1; // 目标值在左半部分
            }
        }
        return -1;
    }

}
