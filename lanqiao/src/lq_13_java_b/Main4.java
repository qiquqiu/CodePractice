package lq_13_java_b;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Node(i, sc.nextInt()));
        }

        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                // 升序排列，集合中的索引就是排序后的索引
                return Integer.compare(o1.val, o2.val);
            }
        });

        // 遍历每个人，针对每个人计算他还需要的刷题数目
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            // 先找出自己在排序后的列表中的索引，从而找出前面，后面各有几个
            int smallerCnt = i;
            int biggerCnt = n - i - 1;

            int index1 = 0, index2 = 0;
            int curVal = list.get(i).val;
            while (index1 + 1 + i < n && list.get(i + index1 + 1).val == curVal) {
                index1++;
                biggerCnt--;
            }
            while (index2 - 1 + i >= 0 && list.get(i - index2 - 1).val == curVal) {
                index2++;
                smallerCnt--;
            }
            // 判断当前是否已经满足条件
            if (biggerCnt > smallerCnt) {
                // 不满足条件，计算本人需要变大导致有几人后移
                // 需要后移的人 x>=(big-sma)/2,即x_min=[~]向大取整
                int x = (biggerCnt - smallerCnt + 1) / 2 + index1;
                // 本人要前移x位，就代表至少要刷题数比本人前x位的人的刷题书多1
                if (i + x < n) {
                    result[list.get(i).priIndex] = list.get(i + x).val - curVal + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

class Node {
    // 原值
    int val;
    // 原始索引，第几个同学
    int priIndex;

    public Node(int priIndex, int val) {
        this.priIndex = priIndex;
        this.val = val;
    }
}
