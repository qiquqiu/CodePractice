package _01Infor;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tool {
    static ArrayList<String> list;

    public static void main(String[] args) {
        list = new ArrayList<>();
        FileReader fr = null;
        StringBuilder sb = new StringBuilder();
        String path = "......\\_01Infor\\001题目类型及知识点说明.txt";
        try {
            fr = new FileReader(path);
            int a;
            while ((a = fr.read()) != -1) {
                if (a == '\n') {
                    list.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append((char) a);
//                    if (sb.toString().contains("lc977-有序数组的平方-数组类问题-双指针解决（双向指针法")) {
//                    }
                }
            }
            list.add(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 按照使用的数据结构和算法来归类题型
        int sum = 0;
        for (String s : list) {
            if (s.contains("二叉树") && s.contains("遍历")) {
                sum++;
                System.out.println(s);
            }
        }
        System.out.println("共找到符合要求的" + sum + "条数据！");

//        findByNo(1047);
    }

    public static void findByNo(int no) {
        for (String s : list) {
            String key = "lc" + no;
            if (s.substring(0, key.length()).equals(key)) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("未找到第" + no + "题!");
    }

    public static void noUse() {

    }
}
