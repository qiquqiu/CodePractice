package lq_14_java_b;

import java.util.*;

/**
 * 思路是没问题的，但真不知道为什么只能过70%
 */
public class Main6 {
    static int cost = 0;
    static int remain = 0;

    public static void main(String[] args) {
        // 首先提取题目，前二贵的商品无论如何掏钱买，但是由于有买二送一，所以必定将前二贵的一起买是最划算的
        // 这是必然会执行的操作，应当是入口
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 使用数组或者集合各有其优劣
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        list.sort(Integer::compare);
        remain = n;

        recursion(list);
        System.out.println(cost);
    }

    public static void recursion(List<Integer> list) {
        if (list.isEmpty() || remain == 0) {
            return;
        }

        if (list.size() == 1) {
            cost += list.get(0);
            remain--;
            return;
        }

        // n没变，若总用size则要恒为-1
        int size = list.size();
        cost += list.get(size - 1);
        list.remove(size - 1);
        int cheaper = list.get(size - 2);
        cost += cheaper;
        list.remove(size - 2);
        remain -= 2;

        // 把每次买最贵的两件送的不超过 cheaper/2 的商品拿下
        // 如果拿下失败（连最便宜的都换不了），说明从现在开始，现存所有商品都要购买
        if (delTarget(list, cheaper / 2)) {
            remain--;
            recursion(list);
        } else {
            // 全部购买
            for (int i = list.size() - 1; i >= 0; i--) {
                cost += list.get(i);
                list.remove(i);
                remain--;
            }
        }
    }

    /**
     * 删除list（已升序有序）中最大的小于等于target的值
     *
     * @param list   已升序有序的列表
     * @param target 目标值
     */
    public static boolean delTarget(List<Integer> list, int target) {
        if (list.isEmpty()) {
            return false; // 列表为空，直接返回
        }
        int l = 0, r = list.size() - 1;
        int resultIndex = -1; // 用于记录要删除的元素索引
        // 二分查找
        while (l <= r) {
            int mid = (l + r) / 2;
            if (list.get(mid) < target) {
                resultIndex = mid; // 记录当前可能的最大小于target的索引
                l = mid + 1;
            } else if (list.get(mid) > target) {
                r = mid - 1;
            } else {
                list.remove(mid); // 找到等于target的元素，直接删除
                return true;
            }
        }
        // 如果没有找到等于target的元素，删除最大的小于target的元素
        if (resultIndex != -1) {
            list.remove(resultIndex);
            return true;
        } else {
            // 没有比target小于或者便宜的商品，无法换取
            return false;
        }
    }
}
