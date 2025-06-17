package lq_12_java_b;

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long milliseconds = scanner.nextLong(); // 读取输入的毫秒数
        // 转换为总秒数
        long totalSeconds = milliseconds / 1000;
        // 计算小时、分钟和秒
        int hours = (int) (totalSeconds / 3600) % 24; // 小时范围 0-23
        int minutes = (int) (totalSeconds % 3600) / 60; // 分钟范围 0-59
        int seconds = (int) totalSeconds % 60; // 秒范围 0-59
        // 格式化输出
        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        System.out.println(time);

    }
}
