package douyinway;

import java.util.Scanner;

public class Main1622 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] ans = new long[]{0, 1, 2, 9, 44, 265, 1854, 14833, 133496, 1334961, 14684570L, 176214841L, 2290792932L, 32071101049L, 481066515734L, 7697064251745L, 130850092279664L, 2355301661033953L, 44750731559645106L, 895014631192902121L};
        String input = "";
        while (sc.hasNextLine()) {
            input = sc.nextLine();
            int index = Integer.parseInt(input) - 1;
            System.out.println(ans[index]);
        }
    }

    // 可以推导公式求，但是太麻烦
    public static long cal(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        long all = fac(n);

        long toSub = 0;
        for (int i = 1; i <= n; i++) {
            toSub += cnm(n, i) * cal(n - i);
        }
        return all - toSub;
    }

    public static long fac(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fac(n - 1);
    }

    // 从n中选m个的组合
    public static long cnm(int n, int m) {
        if (m == 1) {
            return n;
        }
        if (m == n) {
            return 1;
        }
        long sum = 1;
        for (int i = m + 1; i <= n; i++) {
            sum *= i;
        }
        return sum / fac(n - m);
    }
}
