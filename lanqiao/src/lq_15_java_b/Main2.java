package lq_15_java_b;

import java.util.ArrayList;

/**
 * 同样，与第一题类似，也是数学题，只需要最终结果，所以无需考虑程序性能
 */
public class Main2 {
    public static void main(String[] args) {
        // 找从一千万到零之间最大的符合特征的数字
        for (int i = 10000000; i >= 0 ; i--) {
            if (isFibNum(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    /**
     * 判断给定的数字num是否是类斐波那契循环数
     */
    public static boolean isFibNum(int num) {
        ArrayList<Integer> arr = new ArrayList<>();
        String numStr = String.valueOf(num);
        int n = numStr.length();
        for (int i = 0; i < n; i++) {
            arr.add(Character.getNumericValue(numStr.charAt(i)));
        }

        // 不断根据通项公式计算第n项之后的项，直到大于等于num停止
        int sum = 0, i = 0;
        while (sum < num) {
            sum = calInRange(arr, i, n - 1 + i);
            arr.add(sum);
            i++;
        }
        return sum == num;
    }

    /**
     * 获取数组arr中从begin下标开始到end下标结束之间的数字之和（闭区间）
     */
    public static int calInRange(ArrayList<Integer> arr, int begin, int end) {
        // 手动控制不会出现越界
        int sum = 0;
        for (int i = begin; i <= end; i++) {
            sum += arr.get(i);
        }
        return sum;
    }
}
