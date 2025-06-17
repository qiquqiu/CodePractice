package lq_14_java_b;

import java.util.HashMap;
import java.util.Map;

public class Main1 {
    static Map<Character, Integer> map = new HashMap<>();
    static int cnt = 0;

    public static void main(String[] args) {
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('a', 10);
        map.put('b', 11);
        map.put('c', 12);
        map.put('d', 13);
        map.put('e', 14);
        map.put('f', 15);

        for (int i = 1; ; i++) {
            isLuckNum(i);
            if (cnt == 2023) {
                System.out.println(i);
                break;
            }
        }

    }

    public static boolean isLuckNum(int num) {
        String binary = Integer.toBinaryString(num);

        String octal = Integer.toOctalString(num);

        String hex = Integer.toHexString(num);

        if (num % calSumOfDigit(binary) == 0
                && num % calSumOfDigit(octal) == 0
                && num % calSumOfDigit(String.valueOf(num)) == 0
                && num % calSumOfDigit(hex) == 0) {
            cnt++;
            return true;
        }
        return false;

    }

    // 二进制无非是1、0，应该有某种简单点的判断法，但是由于这是结果题，不看过程， 所以无需考虑时空复杂度
    public static int calSumOfDigit(String x) {
        // 10a 11b 12c 13d 14e 15f
        int sum = 0;
        for (int i = 0; i < x.length(); i++) {
            sum += map.get(x.charAt(i));
        }
        return sum;
    }
}
