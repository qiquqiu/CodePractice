package twopointer._01slidingwindow.fixed.lc1423;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{96, 90, 41, 82, 39, 74, 64, 50, 30};
        int ans = new Solution().maxScore(arr, 8);
        System.out.println("ans = " + ans);
    }
}
