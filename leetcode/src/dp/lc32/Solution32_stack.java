package dp.lc32;

import java.util.Stack;

public class Solution32_stack {
    public int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        // 和第一个解法一样，不可避免的，我们必须通过某些操作来同时保存括号的种类和它的索引
        // 而现在只有小括号了，我们可以直接保存左括号的索引+1（防止为0），同时以0或非0区别左右括号
        // 然后就完全没必要使用动态规划解决了，此题则变为一个纯考察栈应用简化问题的题
        // 之所以能够这样，就是由于开始的关键的转化思路！
        Stack<Integer> stack = new Stack<>();
        int len = arr.length;
        int[] transArr = new int[len];
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()) {
                if (arr[i] == ')') {
                    transArr[i] = 1;
                } else {
                    stack.push(i + 1);
                }
            } else {
                if (arr[i] == ')') {
                    if (stack.pop() == 0) {
                        transArr[i - 1] = 1;
                        transArr[i] = 1;
                    }
                } else {
                    stack.push(i + 1);
                }
            }
        }
        // 处理栈中剩余的不匹配括号（左）
        while (!stack.isEmpty()) {
            transArr[stack.pop() - 1] = 1;
        }

        // 至此问题转化为求数组transArr中连续0的最长长度
        // 不必使用动态规划，二维数组int[len][len]空间会超限
        int l = 0, maxLen = 0;
        for (int i = 0; i < transArr.length; i++) {
            if (transArr[i] == 0) {
                l++;
            } else {
                maxLen = Math.max(maxLen, l);
                l = 0;
            }
        }
        return Math.max(maxLen, l);
    }
}
