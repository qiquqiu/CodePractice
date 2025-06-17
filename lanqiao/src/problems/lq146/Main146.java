package problems.lq146;

import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/146/learning/?page_size=10&first_category_id=1&tags=%E7%9C%81%E6%A8%A1%E6%8B%9F%E8%B5%9B&origin=cup&page=1https://www.lanqiao.cn/problems/146/learning/?page_size=10&first_category_id=1&tags=%E7%9C%81%E6%A8%A1%E6%8B%9F%E8%B5%9B&origin=cup&page=1
 */
public class Main146 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = 0; // 记录答案

        // 实际上题目换言之就是找，数是否满足：左边存在一个比他小的数且右边存在一个比他大的数
        // 实际也就是维护某数左边最小的数和右边最大的数即可，只要这两个分别满足条件，那么该数必然满足；否则必然不满足
        // 初步思路：双指针,每遍历完cur移动时，就同时更新index1和index2
        int r = n - 1, leftMinIndex = 0, rightMaxIndex = n - 1;
        while (r > 1) {
            if (arr[r] > arr[rightMaxIndex]) {
                // 只有大才换，保留最右边的
                rightMaxIndex = r;
            }
            r--;
        }
        for (int i = 1; i <= n - 2; i++) {
            if (arr[leftMinIndex] < arr[i] && arr[i] < arr[rightMaxIndex]) {
                ans++;
            }
            // 更新下一个数的leftMin和rightMax
            if (arr[i] < arr[leftMinIndex]) {
                leftMinIndex = i;
            }
            if (i + 1 == rightMaxIndex) {
                rightMaxIndex = reCal(arr, i + 2);
            }
        }
        System.out.println(ans);
    }

    // 计算数组从begin后面最大的数的下标（闭区间）;已控制不会越界
    public static int reCal(int[] arr, int begin) {
        int len = arr.length;
        int maxIndex = len - 1; // 还是优先找最右边的
        for (int i = len - 1; i >= begin; i--) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
