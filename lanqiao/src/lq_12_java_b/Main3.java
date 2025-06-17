package lanqiaoprac.lq_12_java_b;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 本题精度问题未通过，其他都过了
 * 从这套开始感觉跟最新近的都不一样了，填空更多了，反正确实更好拿分了
 * 不过我没有认真潜心做，而且还注意：由于是acm赛制，所以说对于小范围的测试用例，是可以暴力苟分的，大范围则显然超时了
 */
public class Main3 {
    public static void main(String[] args) {
        // x:0-19   y:0-20
        int xmin = 0, xmax = 19, ymin = 0, ymax = 20;
        ArrayList<Point> list = new ArrayList<>();
        for (int i = xmin; i <= xmax; i++) {
            for (int j = ymin; j <= ymax; j++) {
                list.add(new Point(i, j));
            }
        }

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            Point point1 = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                Point point2 = list.get(j);
                set.add(calK(point1, point2));
            }
        }

        System.out.println(set.size());
    }

    public static String calK(Point p1, Point p2) {
        if (p1.y - p2.y == 0) {
            return "y=" + p1.y;
        }
        if (p1.x - p2.x == 0) {
            return "x=" + p1.x;
        }
        double k = (p1.y - p2.y) / (p1.x - p2.x);
        return k + " " + (p1.y - k * p1.x);
    }


}

class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
