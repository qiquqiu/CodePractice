package algorjuniorseries.stack04;

import java.util.Scanner;

public class Stack04Main {
    // ！！！ 不行，不能用哈希表实现，因为哈希表无法处理“相邻”的要求
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        // 还是要用栈来实现
        solutionWithStack(str);
    }

    // 使用StringBuilder模拟栈，原因有二
    // 1.题目没有导入util中的栈
    // 2.最终的结果使用栈不好直接输出
    public static void solutionWithStack(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        int top = -1; // 作为指向实际栈顶的指针
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (sb.isEmpty()) {
                sb.append(cs[i]);
                top++;
            } else {
                // 使用sb.charAt(top)来模拟peek()操作
                // 使用sb.deleteCharAt(top--)来模拟pop()操作
                if (sb.charAt(top) == cs[i]) {
                    sb.deleteCharAt(top--);
                } else {
                    sb.append(cs[i]);
                    top++;
                }
            }
        }
        System.out.println(sb.toString().isEmpty() ? 0 : sb.toString());
    }

    // 废案2
    public static void solution02(String str) {// a b b a a
        while (true) {
            String pre = str;
            str = remove02(str);
            if (str.isEmpty() || pre.equals(str)) {
                break;
            }
        }
        System.out.print(str.isEmpty() ? 0 : str);
    }

    public static String remove02(String str) {
        char[] cs = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int slow = 0;
        int fast = 0;
        int size = 0;
        while (fast <= cs.length) {
            if (fast == cs.length) {
                sb.append(cs[slow]);
                break;
            }
            if (cs[fast] != cs[slow]) {
                size = fast - slow;
                if (size % 2 == 1) {
                    sb.append(cs[slow]);
                }
                slow = fast++;
            } else {
                fast++;
            }
        }
        return sb.toString();
    }

    // 废案1
    public static void solution01(String str) {
        while (true) {
            String pre = str;
            str = remove(str);
            if (str.isEmpty() || pre.equals(str)) {
                break;
            }
        }
        System.out.print(str.isEmpty() ? 0 : str);
    }

    public static String remove(String str) {
        char[] cs = str.toCharArray();
        int[] hash = new int[26]; // 97 ~ 122 小写字母
        StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            // 不需要开128大小的哈希表，26即够用
            hash[c - 97]++;
        }
        for (char aChar : cs) {
            if (hash[aChar - 97] % 2 == 1) {
                sb.append(aChar);
            }
        }
        return sb.toString();
    }
}


