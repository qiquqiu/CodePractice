package lq_9_java_b;

import java.util.*;

public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int gap = sc.nextInt();
        int like = sc.nextInt();

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // 录入数据
        for (int i = 0; i < n; i++) {
            int time = sc.nextInt();
            int id = sc.nextInt();

            List<Integer> list = map.get(id);
            if (list == null) {
                list = new ArrayList<>();
                list.add(time);
                map.put(id, list);
            } else {
                list.add(time);
            }
        }

        sc.close();

        // 将每个id的时间list升序排序
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o1, o2);
                }
            });
        }

        // 遍历每个key的list，每次遍历like个找时间跨度是否小于time
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (hasValidInterval(list, like, gap)) {
                System.out.println(entry.getKey());
            }
        }
    }

    public static boolean hasValidInterval(List<Integer> list, int num, int gap) {
        int n = list.size();
        if (n < num) {
            return false; // 列表长度不足
        }
        for (int i = 0; i <= n - num; i++) {
            int j = i + num - 1; // 维护[i, j]滑动窗口，长度为num
            // 只检查长度为num的固定窗口，虽然大于等于num如果有满足条件的也符合
            // 但是如果区间跨度大于等于num时候满足，那么为num时必定满足（因为时间值升序），这是必要条件
            int currentGap = list.get(j) - list.get(i);
            if (currentGap < gap) {
                return true;
            }
        }
        return false;
    }

}
