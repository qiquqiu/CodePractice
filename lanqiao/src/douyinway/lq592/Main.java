package douyinway.lq592;

/**
 * https://www.lanqiao.cn/problems/592/learning/?page=1&first_category_id=1&sort=problem_id&asc=1&name=%E9%97%A8%E7%89%8C
 */
public class Main {
    public static void main(String[] args) {
        int cnt = 0;
        for(int i = 1; i <= 2020; i++) {
            String n = String.valueOf(i);
            for (int j = 0; j < n.length(); j++) {
                if (n.charAt(j) == '2') {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
