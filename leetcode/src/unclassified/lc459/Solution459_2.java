package unclassified.lc459;

import java.util.Arrays;

public class Solution459_2 {
    // 优化解法
    // 法三：借助KMP算法中的next数组以及一条结论
    // 若是重复字符串，则最小重复单元一定是原字符串去除其最大相等前后缀所得的部分
    public boolean repeatedSubstringPattern(String s) {
        // 先计算next数组，这里必须计算每个数都减1的next数组而不是每个数右移的next数组
        int len = s.length();
        int[] next = new int[len];
        getNext(next, s);
        System.out.println("next 数组 " + Arrays.toString(next));

        // 再使用结论
        int remain = len - (next[len - 1] + 1);
        if (remain == 0) {
            return true;
        }
        if (remain == len) {
            return false;
        }
        return len % remain == 0;
    }

    // 计算next数组，这里可以计算只能求出每个数都减1的next数组而非右移的next数组
    // 其实直接求原始前缀表，即“为经移动的next数组”也可以，我们并不将其用于其他地方
    // 所以不用担心出现死循环

    // 这里求的就是所有值减1后的next数组
    public void getNext(int[] next, String s) {
        int k = -1;
        next[0] = k;
        for (int j = 1; j < s.length(); j++) {
            // 由于这里求的next数组是没有移动的，所以说s[j]想要‘继续’判断是否+1
            // 需要与s[k+1]进行比较，而不是s[k]
            while (k >= 0 && s.charAt(j) != s.charAt(k + 1)) {
                k = next[k];
                // 若不相等，则继续向前递推，直到k=-1，或者s[j]与s[0]相等
            }
            // 此时 k=-1，或者s[j]与s[0]相等
            if (s.charAt(j) == s.charAt(k + 1)) {
                k++;
            }
            // 若还是不相等就是直接赋值-1，注意这种规则下求的next数组中的“-1”
            // 就相当于右移求的next数组中的“0”，也就是最大相等前后缀长度为0
            next[j] = k;
        }
    }
}
