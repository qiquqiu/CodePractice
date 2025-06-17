package problems.lq782;

import java.util.Scanner;

public class Main782 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = null;
        String input = sc.nextLine();
        arr = input.split(" ");
        sort(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }
        sc.close();
    }

    public static void sort(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].charAt(0) < arr[j + 1].charAt(0)) {
                    String t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                } else if (arr[j].charAt(0) == arr[j + 1].charAt(0)) {
                    if (arr[j].length() == arr[j + 1].length()) {
                        if (Integer.parseInt(arr[j]) < Integer.parseInt(arr[j + 1])) {
                            String t = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = t;
                        }
                    } else {
                        int k = 1;
                        boolean flag = false;
                        while (k < arr[j].length() && k < arr[j + 1].length()) {
                            if (arr[j].charAt(k) < arr[j + 1].charAt(k)) {
                                String t = arr[j];
                                arr[j] = arr[j + 1];
                                arr[j + 1] = t;
                                flag = true;
                                break;
                            } else if (arr[j].charAt(k) == arr[j + 1].charAt(k)) {
                                k++;
                            } else {
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) {
                            if (Integer.parseInt(arr[j]) < Integer.parseInt(arr[j + 1])) {
                                String t = arr[j];
                                arr[j] = arr[j + 1];
                                arr[j + 1] = t;
                            }
                        }
                    }
                }
            }
        }
    }
}