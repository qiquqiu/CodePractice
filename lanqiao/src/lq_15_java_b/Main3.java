package lq_15_java_b;

import java.util.Scanner;

public class Main3 {
    static int[] queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        queue = new int[n];

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            dealOrder(line);
        }

        sc.close();
    }

    public static void dealOrder(String order) {
        if (order.contains("query")) {
            int min = queue[1];
            for (int i = 1; i < queue.length; i++) {
                if (queue[i] < min) {
                    min = queue[i];
                }
            }
            System.out.println(min);
        } else if (order.contains("add")) {
            queue[0] = queue[0] + 1; // 头节点增加一个数据
        } else if (order.contains("sync")) {
            int index = Integer.parseInt(order.split(" ")[1]);
            if (queue[index] < queue[0]) {
                queue[index] = queue[index] + 1;
            }
        }
    }
} 