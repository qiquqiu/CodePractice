package twopointer._01slidingwindow.fixed.lc1652;

import java.util.Arrays;

/**
 * 也是定长滑动窗口变式，就是多了一个循环操作数组
 * 只要解决实现了“循环数组”，一切操作都一样了
 * 事实上此题虽是简单题，但是滑动窗口 O(n) 也正是此题击败100%的最优解
 */
public class Solution {
    private int len;

    public int[] decrypt(int[] code, int k) {
        if (k == 0) {
            Arrays.fill(code, 0);
            return code;
        }
        int sum = 0, l, index = 0, r;
        len = code.length;
        int[] ans = new int[len];

        if (k > 0) {
            l = movePtr(0, 1, 1);
        } else {
            k = -k;
            l = movePtr(0, 0, k);
        }

        r = l;
        for (int i = 0; i < k; i++) {
            // 先确定第一段区间和
            sum += code[r];
            r = movePtr(r, 1, 1);
        }
        while (true) {
            if (index == len) {
                break;
            }
            // 填充答案
            ans[index++] = sum;
            // 滑动窗口右移
            sum -= code[l];
            sum += code[r];

            l = movePtr(l, 1, 1);
            r = movePtr(r, 1, 1);
        }

        return ans;
    }

    // 将指定数组索引指针ptr按照direc向左或向右循环移动t位(由于指针是int，直接修改没用，所以需要返回)
    private int movePtr(int ptr, int direc, int t) {
        // 0为左移；1为右移
        return direc == 0 ? (ptr + len - t) % len : (ptr + len + t) % len;
    }
}
