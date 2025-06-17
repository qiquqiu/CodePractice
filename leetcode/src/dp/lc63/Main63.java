package dp.lc63;

public class Main63 {
    public static void main(String[] args) {
        Solution63 s = new Solution63();
        int[][] arr = new int[][]{{0, 0, 0, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0,}, {1, 0, 0, 0, 0}};
        int ret = s.uniquePathsWithObstacles(arr);
        System.out.println(ret);
    }
}
