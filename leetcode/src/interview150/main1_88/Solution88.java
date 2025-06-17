package interview150.main1_88;

import java.util.Arrays;

public class Solution88 {
    // 二刷
    // 要求是原地合并，但是原地合并挪移时间太浪费，可空间换时间
    public void merge(int[] nums1, int m, int[] arr2, int n) {
        // 和归并排序中一处思路一致
        int[] arr1 = Arrays.copyOf(nums1, m);

        int p1 = 0, p2 = 0, t = 0;
        while (p1 < m && p2 < n) {
            if (arr1[p1] < arr2[p2]) {
                nums1[t++] = arr1[p1++];
            } else {
                nums1[t++] = arr2[p2++];
            }
        }

        // 看谁先到头
        while (p1 < m) {
            // arr2先遍历完毕，arr1剩余的填充即可
            nums1[t++] = arr1[p1++];
        }

        while (p2 < n) {
            nums1[t++] = arr2[p2++];
        }

        System.out.println(Arrays.toString(nums1));
    }
}