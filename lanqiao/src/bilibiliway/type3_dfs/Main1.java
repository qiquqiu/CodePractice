package bilibiliway.type3_dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P1219
 * n皇后问题，递归加回溯
 */
public class Main1 {
    // 合理选择判断对角线的方式，不需要设定过多标记变量
    static List<List<Integer>> ans;
    static boolean[] hasChess; // 记录j列是否已经在list中
    static int n;

    public static void main(String[] args) {
        n = new Scanner(System.in).nextInt();
        ans = new ArrayList<>();
        hasChess = new boolean[n];

        dfs(0, new ArrayList<>());

        for (int i = 0; i < 3; i++) {
            List<Integer> list = ans.get(i);
            for (int x : list) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        System.out.print(ans.size());
    }

    // i 行标
    public static void dfs(int i, List<Integer> list) {
        for (int j = 0; j < n; j++) {
            // 判断该位置是否满足行列对角要求
            if (hasChess[j]) { // TODO 可以优化用boolean存，这里contains是O(n) 优化后最大的测试点才能过
                // 该列已经被占据了，下一列
                continue;
            }

            // 列上不重复，判断两条对角线方向是否有棋子；行上不用判断，因为当前就是在行上找
            if (!isValidDiagonal(i, j, list)) {
                continue;
            }

            // 直到都符合
            list.add(j + 1);
            hasChess[j] = true;

            if (i == n - 1) {
                // 已经是最后一行，添加该结果集，结束当前层
                // 只是不再向下递归了（递归终止处）而非不回溯了，还是要回溯的！
                ans.add(new ArrayList<>(list));
            } else {
                // 否则继续向下层搜索
                dfs(i + 1, list);
            }

            // 回溯：该第i层的该位置dfs完毕之后，回来继续检查该行的其他位置，需要复原list和hasChess
            list.remove(list.size() - 1); // 因为是逐行回溯，所以放心删除最后一个就是刚刚该行添加的那个
            hasChess[j] = false;
        }
    }

    // 检查对角线是否冲突
    public static boolean isValidDiagonal(int row, int col, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int j = list.get(i) - 1;
            // 并非遍历整个棋盘，而是仅仅遍历已经落的子即可！判断与已落下的棋子是否能构成+-45度的直线！
            if (Math.abs(row - i) == Math.abs(col - j)) {
                return false;
            }
        }
        return true;
    }
}
