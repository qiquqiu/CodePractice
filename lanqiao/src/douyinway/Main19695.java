package douyinway;

public class Main19695 {
    public static void main(String[] args) {
        int ans = 0;
        boolean[][] isShake = new boolean[50][50]; // 第i人和第j人是否握过手
        for (int i = 0; i < 7; i++) {
            // 7人彼此之间没有进行握手(但这7人与除这7人以外的所有人进行了握手)
            for (int j = 7; j < 50; j++) {
                isShake[i][j] = true;
                ans++;
            }
        }

        for (int i = 7; i < 50; i++) {
            for (int j = i + 1; j < 50; j++) {
                if (i != j && !isShake[i][j]) {
                    isShake[i][j] = true;
                    ans++;
                }
            }
        }

        System.out.println(ans); // 1204
    }
}
