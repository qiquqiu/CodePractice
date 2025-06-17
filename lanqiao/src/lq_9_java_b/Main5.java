package lq_9_java_b;

import java.util.Arrays;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }

        sc.close();

        Arrays.sort(a);
        Arrays.sort(b);

        int[] pa = new int[n];
        int[] pb = new int[n];

        // 先计算pa[i]代表数组a中小于b[i]的数的个数：从升序a中找到第一个小于b[i]的数，答案为其索引+1
        // nlog(n)
        for (int i = 0; i < n; i++) {
            int index = findFirstLT(a, b[i]);
            int index2 = findFirstLT(b, c[i]);
            if (index != -1) {
                pa[i] = index + 1;
            }
            if (index2 != -1) {
                pb[i] = index2 + 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 遍历每个c[i]，二次遍历每个c[i]的 在b中比c[i]小的所有数，再累加每个b[j]的pa[j]的数量
            if (pb[i] != 0) {
                // 说明该c[i]在b中有小于它的数
                int lastIndex = pb[i] - 1; // b中小于c[i]的数的最后一个
                // 从lastIndex起，依次遍历这些b中数据
                for (int j = lastIndex; j >= 0; j--) {
                    // 找这些个b中的数据，在a中有多少个小于他们的数据
                    ans += pa[lastIndex];
                }
            }

        }

        System.out.println(ans);

    }

    // 在升序数组arr中找到第一个小于x的数，返回其索引(l、r取闭区间)
    public static int findFirstLT(int[] arr, int x) {
        int l = 0, r = arr.length - 1, index = -1, mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] < x) {
                index = mid; // mid是当前轮次的保底
                l = mid + 1;
            } else { // arr[mid] >= x
                r = mid - 1;
            }
        }
        return index;
    }

}