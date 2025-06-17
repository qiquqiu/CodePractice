package douyinway.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main16583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("\\s+");

        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long key = (long) Integer.parseInt(str[i]) * (i + 1);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int ans = 0;

        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (val >= 2) {
                ans += cn2(val);
            }
        }

        System.out.println(ans);
    }

    public static int cn2(int n) {
        // 从n个数中选择2个的组合
        return n * (n - 1) / 2;
    }
}
