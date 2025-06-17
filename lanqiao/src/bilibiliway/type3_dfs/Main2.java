package bilibiliway.type3_dfs;

import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P2036
 * 核心思路就是发现这是O(2^n)的dfs搜索
 */
public class Main2 {
    static int ans = Integer.MAX_VALUE;
    static int[] arr1;
    static int[] arr2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr1 = new int[n];
        arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
            arr2[i] = sc.nextInt();
        }

        dfs(0, 1, 0, false);
        System.out.println(ans);
        // 每组数据都有“选”或“不选”两种情况，所以实际按复杂度为O(2^n)，按照这个思路搜索即可
    }

    // 获取从index开始的数据组中满足题意的结果，更新到val1和val2中
    public static void dfs(int index, int val1, int val2, boolean hasSelected) {
        if (index == arr1.length) {
            // 到n时候处理，这样n-1的情况就可以被递归自己处理到了
            if (hasSelected) {
                ans = Math.min(ans, Math.abs(val1 - val2));
            }
            return; // 一个都没选或者处理完最后情况结束递归
        }

        // 选择当前配料，选了就标记下一次进入的isSelected为true
        dfs(index + 1, val1 * arr1[index], val2 + arr2[index], true);
        // 不选当前配料，标记为false（第一次时）（所以不能直接维护一个boolean设为true）
        dfs(index + 1, val1, val2, hasSelected);
    }

    // 原解法存在的问题，只有选到了最后才更新，如果是选的中间某段为答案就不会更新到
    /*public static int dfs(int index, int val1, int val2) {
        if (index == arr1.length - 1) {
            return Math.min(Math.abs(val1 * arr1[index] - (val2 + arr2[index])), ans);
        }

        ans = Math.min(
                dfs(index + 1, val1 * arr1[index], val2 + arr2[index]),
                dfs(index + 1, val1, val2)
        );
        return ans;
    }*/
}
