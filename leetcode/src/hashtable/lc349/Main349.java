package hashtable.lc349;

import java.util.Arrays;

public class Main349 {
    // 双指针法解决求两个数组的交集（先排序）
    // 输入：nums1 = [4, 9, 5], nums2 = [9, 4, 9, 8, 4]
    // 排序：nums2 = [4, 5, 9], nums2 = [4, 4, 8, 9, 9]
    // 输出：[9, 4]

    // 提示：
    // 1 <= nums1.length, nums2.length <= 1000
    // 0 <= nums1[i], nums2[i] <= 1000
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, pre = 1001, index = 0, len1 = nums1.length, len2 = nums2.length;
        int[] temp = new int[Math.max(len1, len2)];
        while (i < len1 && j < len2) {
            if (nums1[i] == nums2[j] && nums1[i] != pre) {
                temp[index++] = nums1[i];
                pre = nums1[i]; // 保存上一次添加到交集的元素
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] res = new int[index];
        System.arraycopy(temp, 0, res, 0, index);
        return res;
    }
}
