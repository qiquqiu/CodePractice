package lq_14_java_b;

import java.util.*;

public class Main5 {
    static int sum = 0, len = 0;
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        len = n;
        int[][] arr1 = new int[n][n];
        int[][] arr2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }

        List<Integer> list1 = calMaxLinkArea(arr1);
        List<Integer> list2 = calMaxLinkArea(arr2);

        Collections.sort(list1, (o1, o2) -> Integer.compare(Math.abs(o2), Math.abs(o1)));
        Collections.sort(list2, (o1, o2) -> Integer.compare(Math.abs(o2), Math.abs(o1)));

        int arr1Val1 = list1.get(0);
        int arr2Val1 = list2.get(0);
        if (arr1Val1 >= 0 && arr2Val1 >= 0) {
            // 若两块区域的最大土地均涉及到了区域边缘，必然可以合并
            System.out.println(arr1Val1 + arr2Val1);
        } else if (arr1Val1 * arr2Val1 < 0) {
            // 若区域1的最大土地涉及了边缘，区域2的最大土地没涉及边缘
            // 就比较：区域1的最大值和区域2的第一个涉及边缘的土地之和 与 区域2的最大土地 之间的最大值
            if (arr1Val1 > 0) {
                int ano = 0;
                for (Integer i : list2) {
                    if (i > 0) {
                        ano = i;
                        break;
                    }
                }
                System.out.println(Math.max(arr1Val1 + ano, arr2Val1 * (-1)));
            } else {
                int ano = 0;
                for (Integer i : list1) {
                    if (i > 0) {
                        ano = i;
                    }
                }
                System.out.println(Math.max(arr2Val1 + ano, arr1Val1 * (-1)));
            }
        } else {
            // 若两块区域的最大土地均没有涉及到区域边缘，需要找到涉及到区域边缘的最大的土地相加和单独的最大的比较
            int area1MaxEdge = 0;
            int area2MaxEdge = 0;
            for (Integer i : list1) {
                if (i > 0) {
                    area1MaxEdge = i;
                    break;
                }
            }
            for (Integer i : list2) {
                if (i > 0) {
                    area2MaxEdge = i;
                    break;
                }
            }
            // 判断合并后和单独的哪个大
            int merge = area1MaxEdge + area2MaxEdge;
            int single = Math.min(arr1Val1, arr2Val1);
            System.out.println(Math.max(merge, single * (-1)));
        }
    }

    /**
     * 找到数组中以“1”相连延伸出的区域的面积的最大值
     * @param arr
     * @return
     */
    public static List<Integer> calMaxLinkArea(int[][] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 1) {
                    // 之前由于sum未及时清0导致了小问题
                    sum = 0;
                    dfs(arr, i, j);
                    flag = false;
                    // 找完一片区域，先添加结果集
                    if (sum != 0) {
                        list.add(sum * (flag ? 1 : (-1)));
                    }
                }
            }
        }
        return list;
    }

    /**
     * 向四个方向dfs找为1的值直到找到边界
     * @param arr
     * @param i
     * @param j
     */
    public static void dfs(int[][] arr, int i, int j) {
        if (i < 0 || i >= len || j < 0 || j >= len || arr[i][j] == 0) {
            return;
        }
        if (arr[i][j] == 1) {
            sum++;
            arr[i][j] = 0;
            if (i == 0 || i == len - 1 || j == 0 || j == len - 1 || !flag) {
                flag = true;
            }
        }
        dfs(arr, i - 1, j);
        dfs(arr, i + 1, j);
        dfs(arr, i, j - 1);
        dfs(arr, i, j + 1);
    }
}
