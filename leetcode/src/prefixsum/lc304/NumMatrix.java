package prefixsum.lc304;

/**
 * 无论是否按图解思路来，这题都必然是一个 二维前缀和
 */
public class NumMatrix {
    private int[][] matrix;
    private int[][] pre;
    private int m, n;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        pre = new int[matrix.length][matrix[0].length];
        this.m = matrix.length;
        this.n = matrix[0].length;
        // 同时初始化前缀和数组，初始化只需要一次便可以被后续sumRegion多次调用
        init();
    }

    // 前缀和求的这种是没问题的，主要就是后面的使用方式
    private void init() {
        // pre[i]表示到行索引i的行前缀和，pre[i][j]表示行索引i下列索引到j的列前缀和
        // pre[i][j] = pre[i][j - 1] + matrix[i][j]
        pre[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            pre[0][i] = pre[0][i - 1] + matrix[0][i];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    pre[i][j] = pre[i - 1][n - 1] + matrix[i][j];
                } else {
                    pre[i][j] = pre[i][j - 1] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        // 这种二维前缀和，没办法对指定的面积在O(1)内求出来，正解应当是遍历行，每行累加
        // 毕竟当前这种行式的前缀和也只能行遍历求行占用
        int sum = 0;
        // 前面多余的公共n行可以剪掉抵消
        for (int i = row1; i <= row2; i++) {
            if (col1 - 1 >= 0) {
                sum += pre[i][col2] - pre[i][col1 - 1];
            } else {
                sum += pre[i][col2] - (i == 0 ? 0 : pre[i - 1][n - 1]);
            }
        }
        return sum;
    }
}
