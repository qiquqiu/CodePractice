package douyinway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main3621 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        char[] arr = br.readLine().toCharArray();
        int k = Integer.parseInt(br.readLine());// bbbbca
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0, l = 0;
        for (int r = 0; r < arr.length; r++) {
            char c = arr[r];
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > k) {
                // 当当前字符超过 k 次时，移动左指针向左收缩窗口，直到窗口合法
                while (map.get(c) > k) {
                    char leftChar = arr[l];
                    // 针对遇到的所有leftChar
                    map.put(leftChar, map.get(leftChar) - 1);
                    l++;
                }
            } // else不需要处理，因为实际答案是由窗口长度算出来的，不是计数器计数出来的
            // 更新最大长度
            ans = Math.max(ans, r - l + 1);
        }
        System.out.println(ans);
    }
}
