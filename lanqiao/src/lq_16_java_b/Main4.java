package lq_16_java_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

/**
 * https://www.luogu.com.cn/problem/P12157
 * 魔法科考试，效率还可以优化
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int ai = a[i];
            for (int j = 0; j < m; j++) {
                int s = ai + b[j];
                if (s <= n + m && isSuNum(s)) {
                    set.add(s);
                }
            }
        }
        System.out.println(set.size());
    }

    public static boolean isSuNum(int num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
/*
public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int[] a = new int[n];
        int m = Integer.parseInt(input[1]);
        int[] b = new int[m];

        input = br.readLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }
        input = br.readLine().split("\\s+");
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(input[i]);
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int ai = a[i];
            for (int j = 0; j < m; j++) {
                int s = ai + b[j];
                if (s <= n + m && isSuNum(s)) {
                    set.add(s);
                }
            }
        }
        System.out.println(set.size());
    }
*/