package twopointer._01slidingwindow.fixed.lc2461;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{1, 1, 1, 7, 8, 9};
        long ans = s.maximumSubarraySum(arr, 3);
        System.out.println("ans = " + ans);
    }
}
