package bilibiliway.type1_tanxin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.luogu.com.cn/problem/U535982
 * 其实对于本题的 loop=1的50%数据来说，可以直接分类讨论n的情况只拿50%的分
 * 但是以下是思路以及正解
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        for (int l = 0; l < loop; l++) {
            int n = Integer.parseInt(br.readLine());
            char[] arr = br.readLine().toCharArray();
            // 经过分析可以得到，最终调整完毕后合法的串要么是ABABAB...要么是BABABA...
            // 而且所谓的“交换”，本质就是改变两个位置的情况，所以说只需要将原始串与两个结果串对比
            // 看看分别变为他们的“步数”哪个更少即可（这里的“步数”遍历对比一遍就出来了）
            // 而不用真正地取对原始串下手，去分析，遍历原始串的各个字符相邻情况！一个字符都不需要考虑
            // 因为一旦考虑从原来串本身出发，就必然需要涉及到“调换”的规则，这显然是极其麻烦的
            System.out.println(cal(arr));
        }

    }

    // 计算arr变为两种指定标准串中要经历的步数中的小值
    public static int cal(char[] arr) {
        int len = arr.length;
        int step1 = 0, step2 = 0;
        // 甚至不需要构造标准串，直接比较即可
        for (int i = 0; i < len; i++) {
            // 分别将原始串与两个标准串对比算分别的步数
            if (i % 2 == 0) {
                // 奇数位，对第一个标准串来说是A
                step1 = arr[i] == 'B' ? step1 + 1 : step1;
                // 对第二个标准串来说是B
                step2 = arr[i] == 'A' ? step2 + 1 : step2;
            } else {
                // 偶数位，对第一个标准串来说是B
                step1 = arr[i] == 'A' ? step1 + 1 : step1;
                // 对第二个标准串来说是A
                step2 = arr[i] == 'B' ? step2 + 1 : step2;
            }
        }
        return Math.min(step1, step2) / 2;
    }
}
