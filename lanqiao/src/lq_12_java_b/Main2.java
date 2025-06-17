package lanqiaoprac.lq_12_java_b;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        // k(1+k)>=2n
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double k = (Math.sqrt(1 + 8.0 * n) - 1) / 2;
        // 向上取整
        int kz = (int) Math.ceil(k);
        System.out.println(kz);
    }
}
