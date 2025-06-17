package problems.lq06;

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] arr = new int[size];
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scan.nextInt();
        }
        mergeSort(arr,0, arr.length - 1, temp);
        for (int j = 0; j < size; j++) {
            System.out.print(arr[j] + " ");
        }
        scan.close();
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, right, mid, temp);
        }
    }

    public static void merge(int[] arr, int left, int right, int mid, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            int res = (arr[i] < arr[j]) ? (temp[t++] = arr[i++]) : (temp[t++] = arr[j++]);
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        int tempLeft = left;
        for (int k = 0; k < right - left + 1; k++) {
            arr[tempLeft++] = temp[k];
        }
    }
}
