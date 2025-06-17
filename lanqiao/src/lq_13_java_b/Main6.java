package lq_13_java_b;

import java.util.Scanner;

// 通过
public class Main6 {
    public static void main(String[] args) {
        /*69859241839387868941
        17615876963131759284
        37347348326627483485
        53671256556167864743
        16121686927432329479
        13547413349962773447
        27979945929848824687
        53776983346838791379
        56493421365365717745
        21924379293872611382
        93919353216243561277
        54296144763969257788
        96233972513794732933
        81443494533129939975
        61171882988877593499
        61216868895721348522
        55485345959294726896
        32124963318242554922
        13593647191934272696
        56436895944919899246*/
        Scanner sc = new Scanner(System.in);
        byte[][] matrix = new byte[20][20];
        for (int i = 0; i < 20; i++) {
            // 第二次修改：将trim写在input获取之后及时进行，防止粘贴输入的格式导致空格出错
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                for (int j = 0; j < 20; j++) {
                    matrix[i][j] = (byte) Character.getNumericValue(input.charAt(j));
                }
            }
        }

        int maxVal = -1;
        // 暴力遍历，移动求和
        for (int i = 0; i <= 15; i++) {
            for (int j = 0; j <= 15; j++) {
                // 一个[i, j] 左上顶点坐标就是一个框选情况
                maxVal = Math.max(maxVal, cal(matrix, i, j));
            }
        }

        System.out.println(maxVal); // 154
    }

    // 计算某二维数组以[i, j]左上顶点开头的5*5矩阵内容之和
    public static int cal(byte[][] arr, int i, int j) {
        int sum = 0;
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                sum += arr[i + x][j + y];
            }
        }
        return sum;
    }
}
