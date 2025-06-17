package problems.lq145;

import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/145/learning/?page_size=10&first_category_id=1&tags=%E7%9C%81%E6%A8%A1%E6%8B%9F%E8%B5%9B&origin=cup
 */
public class Main145 {
    public static void main(String[] args) {
        // 判断1至n中有多少个数位递增的数，思路，类似动态规划，ret(1到n) = ret(1到n-1) + is(n);故使用递归解决
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solution(n));
    }

    // 主递归方法，返回1到n之间符合条件的数的个数
    public static int solution(int n) {
        if (n == 1) {
            return 1;
        }
        return solution(n - 1) + (check(n) ? 1 : 0);
    }

    /**
     * 判断 数n 是否符合“数位递增”
     * 实现思路，遍历即可;判断条件，从左到右从第二个位开始，值是否总是>=左边的数
     */
    public static boolean check(int n) {
        if (n / 10 == 0) {
            // 个位数直接返回true即可
            return true;
        }
        String numStr = String.valueOf(n);
        int len = numStr.length();
        for (int i = 1; i < len; i++) {
            if (Character.getNumericValue(numStr.charAt(i)) < Character.getNumericValue(numStr.charAt(i - 1))) {
                return false;
            }
        }
        return true;
    }
}
