package lq_16_java_b;

import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P12156
 * dfs但是超时了（dfs超时，意料之中）
 * 问题不在于分组呀！看到了“异或”当时没有特意刷到题，应该是异或的知识，能简化！
 * https://easylink.cc/lgrsd2 哎呀，恰好这块没看，恰好看了dfs导致我用了dfs做的
 *
 */
public class Main3 {
    static int[] arr;
    static int n;
    static boolean isOK;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        for (int i = 0; i < l; i++) {
            n = sc.nextInt();
            arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            isOK = false;
            dfs(0, false, 0, 0);
            System.out.println(isOK ? "YES" : "NO");
        }
    }

    public static void dfs(int curIndex, boolean hasSelect, int chosenSum, int unChosenSum) {
        if (curIndex == n) {
            if (hasSelect) {
                isOK = chosenSum == unChosenSum;
            }
            return;
        }
        // 选择当前索引的值
        dfs(curIndex + 1, true, chosenSum ^ arr[curIndex], unChosenSum);
        // 不选择当前索引的值（使用的是隐式回溯）
        dfs(curIndex + 1, hasSelect, chosenSum, unChosenSum ^ arr[curIndex]);
    }
}
