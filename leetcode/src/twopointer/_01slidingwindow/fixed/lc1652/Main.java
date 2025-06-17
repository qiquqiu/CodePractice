package twopointer._01slidingwindow.fixed.lc1652;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 9, 3};
        int[] ans = new Solution().decrypt(arr, -2);
        System.out.println(Arrays.toString(ans));
    }
}
