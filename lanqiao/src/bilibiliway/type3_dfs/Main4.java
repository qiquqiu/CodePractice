package bilibiliway.type3_dfs;

import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P1036
 * 选数题，之前javaClub做过，但是没用dfs写出来，现在套模板重做
 * 本质还是和之前的从所有子集中选符合的情况的做法（搜索符合集合）
 * 主要小修是在递归函数中多加了个参数index，这是用于表示当前进入
 * 递归时选的数的索引，而后遍历选数的时候，就重他的下一个开始就好了，不要从0开始
 * 不然会选到前面已经选过的的数字，造成同一个组合多次被ans+1
 */
public class Main4 {
    static int ans;
    static int k;
    static boolean[] chosen;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ans = 0; // 显示初始化
        k = sc.nextInt();
        chosen = new boolean[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 开始时候没有选，要保证第一次for i从0开始所以传-1
        dfs(arr, 0, 0, -1);

        System.out.println(ans);
    }

    // index必要，记录当前进入递归时最新选的数的索引，用于标记下次for时候从哪开始防止选到重复组合
    public static void dfs(int[] arr, int sum, int cnt, int index) {
        if (cnt == k) {
            // 已经选够了k个数，计算当前k个数的sum是否符合要求
            ans = isSuNum(sum) ? ans + 1 : ans;
            return;
        }

        // 否则尚未选够k个，还要接着选
        for (int i = index + 1; i < arr.length; i++) {
            if (!chosen[i]) {
                chosen[i] = true;
                dfs(arr, sum + arr[i], cnt + 1, i);
                chosen[i] = false;
            }
        }
    }

    // 判断num是否是素数，即除了1和它本身外没有数能整除
    public static boolean isSuNum(int num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
