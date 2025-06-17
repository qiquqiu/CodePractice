package bilibiliway.type3_dfs;

import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P9242
 * 第一遍只过了1个，理论上这个dfs暴力能过2个才对；错了一个，超时8个
 * 调了半天思路应当没毛病啊，但是dfs的两个就是只能过一个
 */
public class Main6 {
    static int n, ans;
    static String[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ans = Integer.MAX_VALUE;
        sc.nextLine();
        arr = sc.nextLine().split("\\s+");
        // 思路还是类似的，本质还是选集合的子集，对于每个数要么选要么不选
        dfs(0, 1, 1); // 要第一个
        dfs(1, 2, 1); // 不要第一个

        System.out.println(ans);
    }

    /**
     * @param lastIndex 上一个满足接龙的值的索引
     * @param curIndex 当前遍历到的索引（将要检索的）
     * @param curLen 当前符合接龙串的长度（不包含将要检索的）
     */
    public static void dfs(int lastIndex, int curIndex, int curLen) {
        if (curIndex == n) {
            // 如果不被选的话，反正会向下递归索引+1，一定能到索引越界的此时刚好收集结果
            ans = Math.min(ans, n - curLen);
            return;
        }

        // 遍历，每个值要么选要么不选
        String lastStr = arr[lastIndex];
        String curStr = arr[curIndex];

        // 这题也是一样，由于就两种选择，要么选要么不选，没必要循环了
        // 另外注意这里并非是if-else而是两种情况都要选，两条路并行（第一个dfs需要回溯curIndex和curLen）
        if (lastStr.charAt(lastStr.length() - 1) == curStr.charAt(0)) {
            // 选了
            dfs(curIndex, curIndex + 1, curLen + 1); // 这里有隐式回溯
        }

        // 这里必须对“不选这个”的情况也做dfs，而非使用if-else仅做一个
        // 一方面只有两种都搜索了，才算达到了全部子集情况
        // 显然可以举反例，假设选了当前的满足条件的，没考虑当前不满足条件的dfs，那么完全可能正因为跳过了当前这个到后面，才选到了比不跳过的更好的情况

        // 不选
        dfs(lastIndex, curIndex + 1, curLen);
    }
}
