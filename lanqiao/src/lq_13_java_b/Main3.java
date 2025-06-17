package lq_13_java_b;

import java.util.Scanner;

// 通过
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();
        int[] hash = new int[26];
        for (char c : arr) {
            hash[c - 'A']++;
        }

        int maxCnt = 1;
        for (int i : hash) {
            if (i > maxCnt) {
                maxCnt = i;
            }
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == maxCnt) {
                System.out.print((char) (i + 'A'));
            }
        }
    }
}
