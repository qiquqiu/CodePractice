package twopointer._02binary.lc35;

/**
 * （双指针）之二分思想之二分查找典型例题
 */
public class Solution {
    // 找到最大的比target小的索引位置即可，就是改造的二分查找
    public int searchInsert(int[] arr, int target) {
        if (arr.length == 0 || arr[0] > target) {
            return 0;
        }
        int l = 0, r = arr.length - 1, mid = 0, ans = 0;
        while (l <= r) { // 由于是l，r各以+1更新，==的情况并不非法，也要判断
            mid = l + (r - l) / 2;
            if (arr[mid] > target) {
                r = mid - 1;
            } else {
                // arr[mid] <= target
                // 前进更新l，同时保留更新ans
                ans = mid;
                l = mid + 1;
            }
        }
        return arr[ans] == target ? ans : ans + 1;
    }
}
