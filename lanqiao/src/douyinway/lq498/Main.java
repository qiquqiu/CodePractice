package douyinway.lq498;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/498/learning/?page=1&first_category_id=1&sort=problem_id&asc=1&name=%E5%9B%9E%E6%96%87%E6%97%A5%E6%9C%9F
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dateStr = sc.nextLine();

        // 使用java的日期类，可以节省掉最繁杂以及容易导致出错的“日期增加”和“日期格式控制”
        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyyMMdd"));

        date = date.plusDays(1);
        String paDay = "", abDay = "";
        boolean isFind = false;

        while (true) {
            String today = date.toString().replace("-", "");
            if (isPalindrome(today) && !isFind) {
                paDay = today;
                isFind = true;
            }
            if (isABABBABA(today)) {
                abDay = today;
                break;
            }
            date = date.plusDays(1);
        }
        System.out.println(paDay);
        System.out.println(abDay);
        sc.close();
    }

    public static boolean isPalindrome(String str) {
        int l = 0, r = 7;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static boolean isABABBABA(String str) {
        char a1 = str.charAt(0);
        char a2 = str.charAt(2);
        char a3 = str.charAt(5);
        char a4 = str.charAt(7);

        char b1 = str.charAt(1);
        char b2 = str.charAt(3);
        char b3 = str.charAt(4);
        char b4 = str.charAt(6);

        return (a1 == a2 && a2 == a3 && a3 == a4) && (b1 == b2 && b2 == b3 && b3 == b4);
    }
}
