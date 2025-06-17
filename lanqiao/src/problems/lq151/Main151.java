package problems.lq151;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/151/learning/?page_size=10&first_category_id=1&tags=%E7%9C%81%E6%A8%A1%E6%8B%9F%E8%B5%9B&origin=cup&page=1
 */
public class Main151 {
    public static void main(String[] args) {
        // 暴力或者单调栈（贪心法，一遍遍历）
        Deque<Integer> stack = new ArrayDeque<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 遍历每个节目
        for (int i = 0; i < n; i++) {
            // 当栈不为空且栈顶元素小于当前值，并且可以安全弹出保证剩余元素足够凑成 m 个节目时，连续弹出
            while (!stack.isEmpty()
                    && stack.peek() < arr[i]
                    && (stack.size() - 1 + (n - i)) >= m) {
                // (当前栈中元素个数 - 1) + (剩余未遍历(包含当前)的节目数) >= m
                stack.pop();
            }
            // 如果栈中的元素数还没有达到 m 个，就 push 进去
            if (stack.size() < m) {
                stack.push(arr[i]);
            }
            // 如果已经有 m 个元素，并且不满足替换条件，则当前元素就直接跳过（不用加入）
        }

        // 由于栈顶对应的是最后放入的元素，所以需要反转栈中的元素顺序
        int[] result = new int[m];
        for (int i = m - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        // 输出结果（保持原序）
        for (int v : result) {
            System.out.print(v + " ");
        }
    }
}