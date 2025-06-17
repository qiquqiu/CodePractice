package douyinway.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 注意，时间复杂度O(n^2)的算法在数据量N=10^5时候会超时
 */
public class Main17021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("\\s+");

        int[] arr = new int[n];
        // 数组值---出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // 如果这样算 Math的double转long精度倒是没有问题！
        long[] possible = new long[31];
        // 0-29(2^1-2^30次 不足够，还是得加上2^31这个数)
        for (int i = 0; i < possible.length; i++) {
            possible[i] = (long) Math.pow(2, i + 1);
        }

//        List<Long> possible = new ArrayList<>();
//        for (long x = 2; x <= 2_000_000_000L; x *= 2) {
//            possible.add(x);
//        }

        // 这个题条件lowbit(x) = x 可以分析一番：
        // 由于奇数二进制最低位必定是1，而如果对技术做lowbit运算必定是偶数，所以说只有偶数x可能符合条件
        // 由于与2^k本来就是偶数，所以符合条件的x必定是在2^k的集合之中
        // 旧的O(n^2)是必然超时的，所以可以尝试力扣第一题两数和的哈希思路（反正已知的是存在只遍历一遍就通过的方法）
        // 遍历到ai，主动去寻一个aj是否满足和为2^k

        long ans = 0; // 这里必须得是long

        for (int i = 0; i < n; i++) {
            int ai = arr[i];
            for (long k : possible) {
                long aj = k - ai;
                if (aj < 1 || aj > Integer.MAX_VALUE) {
                    continue;
                }
                int ajInt = (int) aj; // 以及此处 aj = (int) aj的语法是错的，一用就错！！！
                if (map.containsKey(ajInt)) {
                    if (ai == ajInt) {
                        ans += map.get(ajInt) - 1;
                    } else {
                        ans += map.get(ajInt);
                    }
                }
            }
            map.put(ai, map.get(ai) - 1);
        }

        System.out.print(ans);
    }


    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("\\s+");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long key = arr[i] + arr[j];
                // 该“和值”已经存在过了，直接次数加1即可
                // 由于是O(n^2)遍历，不存在重复与遗漏
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                    continue;
                }
                // 否则算该“和值”是否是满足要求的
                if (check(key)) {
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }
        }

        int ans = 0;

        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            ans += val;
        }

        System.out.println(ans);
    }

    // 检查x是否满足lowbit(x) = x
    public static boolean check(long x) {
        String binX = Long.toBinaryString(x);
        int len = binX.length();
        for (int i = len - 1; i >= 0; i--) {
            if (binX.charAt(i) == '1') {
                // 遇到最低位的1，算它的值
                return x == (int) Math.pow(2, len - i - 1);
            }
        }
        return false;
    }*/
}
