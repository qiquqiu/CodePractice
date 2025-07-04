package douyinway;

import java.util.Scanner;

public class Main5485 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println(getN(n, arr));
        sc.close();
    }

    public static int getN(int n, int[] arr) {
        if (n <= 2) {
            return 1;
        }
        arr[0] = arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
    }
}
