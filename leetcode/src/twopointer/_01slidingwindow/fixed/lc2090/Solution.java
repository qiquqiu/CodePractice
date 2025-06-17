package twopointer._01slidingwindow.fixed.lc2090;

import java.util.Arrays;

/**
 * 思路和前两个一样，就是边界条件，首尾条件太注意点
 * 不过或许前面几道题都做有点冗余了，其实第一种情况，也就是第一个和数组可以放循环里面算
 */
class Solution {
    public int[] getAverages(int[] arr, int k) {
        int len = arr.length, l = 0;
        long sum = 0L; // sum设定为long才能全过
        int[] avg = new int[len];
        Arrays.fill(avg, -1); // 直接这样左做可以省掉善后工作
        // 长度为2k+1的窗口，和上一题思路几乎一样
        // 显然只有从i=k处开始才可能非-1，之前的全是-1，且这是第一段的和
        if (2 * k + 1 > len) {
            return avg;
        }

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        // 完善第一段区间和
        for (int i = k; i <= 2 * k; i++) {
            sum += arr[i];
        }
        avg[k] = (int) (sum / (2 * k + 1));

        // 以中心点为视角遍历，其中右端通过arr[i + k]获取
        for (int i = k + 1; i < len - k; i++) {
            sum -= arr[l++];
            sum += arr[i + k];
            avg[i] = (int) (sum / (2 * k + 1));
        }

        return avg;
    }

//    public static void main(String[] args) {
//        int[] arr = new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6};
//        int[] avg = new Solution().getAverages(arr, 3);
//    }
}