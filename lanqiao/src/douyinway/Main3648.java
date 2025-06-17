package douyinway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Main3648 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] sp = br.readLine().split("\\s+");
        int len = sp.length;
        int[] arr = new int[len];
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(sp[i]);
            set.add(arr[i]);
        }

        int keyCnt = set.size();
        int ans = len, l = 0;

        for (int r = 0; r < len; r++) {
            // 先遍历直到数量上合法，尚未满足数量上合法或者已从左优化完毕
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            while (map.size() == keyCnt) {
                // 先保存答案
                ans = Math.min(ans, r - l + 1);

                // 数量合法后考虑从left优化
                int leftCnt = map.get(arr[l]);
                if (leftCnt == 1) {
                    map.remove(arr[l]);
                } else {
                    map.put(arr[l], leftCnt - 1);
                }
                l++;
            }
        }

        System.out.println(ans);
    }
}
