package problems.lq07;

import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] arr = new int[size];
        // 53 3 367 366 542 74 90 48 8 676 14 4 214
        for (int i = 0; i < size; i++) {
            arr[i] = scan.nextInt();
        }
        radixSort(arr);
        for (int j = 0; j < size; j++) {
            System.out.print(arr[j] + " ");
        }
        scan.close();
    }

    public static void radixSort(int[] arr) {
        int maxLen = getMaxLenOfArr(arr);
        int[][] bucket = new int[10][arr.length];
        int[] counts = new int[10];
        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < arr.length; j++) {
                int digit = (arr[j] / (int) Math.pow(10, i)) % 10;
                bucket[digit][counts[digit]++] = arr[j];
            }
            int index = 0;
            for (int k = 0; k < 10; k++) {
                if (counts[k] != 0) {
                    for (int t = 0; t < counts[k]; t++) {
                        arr[index++] = bucket[k][t];
                    }
                }
                counts[k] = 0;
            }
        }
    }

    // 获取到数组中最大值的长度（位数）
    public static int getMaxLenOfArr(int[] arr) {
        int max = arr[0];
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > max) {
                max = arr[j];
            }
        }
        return (max + "").length();
    }
}
