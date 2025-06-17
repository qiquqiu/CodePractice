package dp.lc221;

public class Main221 {
    public static void main(String[] args) {
        Solution221 s = new Solution221();
        char[][] arr = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},
        };
        int ret = s.maximalSquare(arr);
        System.out.println(ret);
    }
}
