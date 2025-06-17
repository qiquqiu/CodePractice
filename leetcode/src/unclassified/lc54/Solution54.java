package unclassified.lc54;

import java.util.ArrayList;
import java.util.List;

class Solution54 {
    List<Integer> ret;

    public List<Integer> spiralOrder(int[][] matrix) {
        ret = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int loop = Math.min((m + 1) / 2, (n + 1) / 2);
        for (int i = 0; i < loop; i++) {
            getAround(matrix, m, n, i);
            m -= 2;
            n -= 2;
        }
        return ret;
    }

    // 先尝试类递归思路 m为实际使用的行数，n为实际使用的列数
    private void getAround(int[][] matrix, int m, int n, int beginIndex) {
        if (m == 1) {
            for (int i = 0; i < n; i++) {
                ret.add(matrix[beginIndex][beginIndex + i]);
            }
            return;
        }
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                ret.add(matrix[beginIndex + i][beginIndex]);
            }
            return;
        }
        // 这里有一个主要的注意点就是，循环次数的控制，并不能统一地使用n次
        // 直接作为循环次数，因为开始的时候由于开始索引为0的特殊性，将之省略了
        // 从而引起了后续非第一次的时候的错误情况
        // 另外，还有一个自动处理好了的细节就是区间的开闭保持同样的规则
        // 卡尔思路，与自己思路类似：https://leetcode.cn/problems/spiral-matrix/description/comments/1630917
        for (int i = beginIndex; i < n + beginIndex; i++) {
            ret.add(matrix[beginIndex][i]);
        }
        for (int j = beginIndex + 1; j < m + beginIndex; j++) {
            ret.add(matrix[j][n - 1 + beginIndex]);
        }
        for (int k = n - 2 + beginIndex; k >= beginIndex; k--) {
            ret.add(matrix[m - 1 + beginIndex][k]);
        }
        for (int t = m - 2 + beginIndex; t > beginIndex; t--) {
            ret.add(matrix[t][beginIndex]);
        }
    }
}