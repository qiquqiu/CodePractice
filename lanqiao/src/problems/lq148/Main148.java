package problems.lq148;

import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/148/learning/?page_size=10&first_category_id=1&tags=%E7%9C%81%E6%A8%A1%E6%8B%9F%E8%B5%9B&origin=cup&page=1
 */
public class Main148 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char[] charArr = input.toCharArray();
        if (!isFuYin(charArr[0])) {
            System.out.println("no");
            return;
        }
        boolean lastIsFuYin = true;
        int changeCnt = 1;
        for (int i = 0; i < charArr.length; i++) {
            if (!isFuYin(charArr[i]) && lastIsFuYin) {
                changeCnt++;
                lastIsFuYin = false;
            } else if (isFuYin(charArr[i]) && !lastIsFuYin) {
                changeCnt++;
                lastIsFuYin = true;
            }
        }
        System.out.println(changeCnt == 4 ? "yes" : "no");
    }

    public static boolean isFuYin(char c) {
        return !(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
