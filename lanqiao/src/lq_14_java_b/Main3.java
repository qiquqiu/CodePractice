package lq_14_java_b;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 计算公式 S1+S2-重叠区域面积
        String[] input = sc.nextLine().trim().split(" ");
        int x1, x2, x3, x4, y1, y2, y3, y4;
        x1 = Integer.parseInt(input[0]);
        y1 = Integer.parseInt(input[1]);
        x2 = Integer.parseInt(input[2]);
        y2 = Integer.parseInt(input[3]);
        x3 = Integer.parseInt(input[4]);
        y3 = Integer.parseInt(input[5]);
        x4 = Integer.parseInt(input[6]);
        y4 = Integer.parseInt(input[7]);

        // 重叠区域面积计算通式
        int lx = Math.max(x1, x3);
        int rx = Math.min(x2, x4);
        int ty = Math.min(y2, y4);
        int by = Math.max(y1, y3);

        int coArea = Math.max((rx - lx) * (ty - by), 0);

        System.out.println((x2 - x1) * (y2 - y1) + (x4 - x3) * (y4 - y3) + coArea);
    }
}
