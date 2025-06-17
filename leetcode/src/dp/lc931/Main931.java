package dp.lc931;

public class Main931 {
    public static void main(String[] args) {
        Solution931 s = new Solution931();
        int[][] matrix = new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        int ret = s.minFallingPathSum(matrix);
        System.out.println(ret);
    }
}
