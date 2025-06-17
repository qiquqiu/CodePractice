package twopointer.lc88;

public class Solution88 {
    // nums1长度为m+n（只有m个有效数据）；nums2长度为n
    // 类似“归并排序”里面的合并操作的双指针
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int index = 0, i = 0, j = 0;
        while (i < m && j < n) {
            int t = nums1[i] < nums2[j] ? (res[index++] = nums1[i++]) : (res[index++] = nums2[j++]);
        }
        //  nums1已经遍历完毕了
        if (i == m) {
            for (int k = j; k < n; k++) {
                res[index++] = nums2[k];
            }
        }
        // nums2已经遍历完毕了
        if (j == n) {
            for (int k = i; k < m; k++) {
                res[index++] = nums1[k];
            }
        }
        // 由于最后要把结果存到nums1里面，所以改一下引用即可
        // 但是nums1还是没变，说明该题目不是检测nums1，而是在外面检测初始nums1指向的对象
        // 所以说还是要赋值一下
        for (int t = 0; t < m + n; t++) {
            nums1[t] = res[t];
        }
    }
}