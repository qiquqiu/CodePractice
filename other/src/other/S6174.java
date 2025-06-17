package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S6174 {
    static int maxStep;

    public static void main(String[] args) {
        List<List<Integer>> collection = new ArrayList<>();
        maxStep = 0;
        for (int i = 1001; i <= 9999; i++) {
            if (i % 1111 == 0) {
                continue;
            }
//            System.out.println("i = " + i);
            List<Integer> list = process(i);
            collection.add(list);
        }

        int i = 1;
        System.out.println("1001到9999，共有" + collection.size() + "个数满足");
        for (List<Integer> list : collection) {
            System.out.print("第" + (i++) + "个:\t" + list.getFirst() + "--->");
            System.out.println(list);
        }
        System.out.println("其中最长的步数为：" + maxStep);
    }

    public static List<Integer> process(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(n);
        int[] arr = new int[4];
        int ret = 0, step = 0;
        while (ret != 6174) {
            step++;
            for (int i = 0; i < 4; i++) {
                arr[i] = n % 10;
                n /= 10;
            }
            Arrays.sort(arr);
            int big = arr[3] * 1000 + arr[2] * 100 + arr[1] * 10 + arr[0];
            int small = arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];
            ret = big - small;
            n = ret;
            list.add(ret);
        }
        maxStep = Math.max(step, maxStep);
        return list;
    }
}
