package bilibiliway.type1_tanxin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://ac.nowcoder.com/acm/contest/103948/B
 */
public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = 0;
        // 先排序再模拟总是取最小即可
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                // 奇数第一个操作，即小红先手加
                x += arr[i];
            } else {
                x -= arr[i];
            }
        }
        System.out.println(x);
    }
}
