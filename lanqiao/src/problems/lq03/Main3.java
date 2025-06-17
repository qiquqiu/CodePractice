package problems.lq03;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int slow = 0, fast = 0, count = 0;
        while (fast <= chars.length) {
            if (fast != chars.length && chars[slow] == chars[fast]) {
                fast++;
                count++;
            } else {
                sb.append(chars[slow]);
                if (count != 0 && count != 1) {
                    sb.append(count);
                }
                count = 0;
                slow = fast;
                if (fast == chars.length) {
                    break;
                }
            }
        }
        System.out.print(sb.toString().length() < str.length() ? sb.toString() : "NO");
        scan.close();
    }
}
