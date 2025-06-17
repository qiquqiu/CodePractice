package douyinway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int max = -1, min = Integer.MAX_VALUE, sum = 0;

        for (int i = 0; i < n; i++) {
            int s = Integer.parseInt(br.readLine());
            max = Math.max(max, s);
            min = Math.min(min, s);

            sum += s;
        }

        System.out.println(max);
        System.out.println(min);
        System.out.printf("%.2f", sum / (double) n);
        br.close();
    }
}
