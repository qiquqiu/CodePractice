package dp.lc32;

import java.util.ArrayList;
import java.util.Stack;

public class Solution32_harder {
    // 求最长有效括号
    // [}]()([{}]

    // 写完再读题才发现写麻烦了，题目说“括号”只包含“( )”，所以说匹配逻辑做麻烦了
    // 并且也不用实现SignIndex类了；全是小括号或许开始更易想到这种思路
    // 不过答案没有问题，就是由于多定义了个类内存超限了，不过可以解决三种括号的混合问题
    // 且最关键的dp判断环节是没有问题的
    public int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        Stack<SignIndex> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()) {
                if (getType(arr[i]) == 1) {
                    list.add(i);
                } else {
                    stack.push(new SignIndex(arr[i], i));
                }
            } else {
                if (getType(arr[i]) == 1) {
                    if (!isMatch(stack.pop().sign, arr[i])) {
                        list.add(i - 1);
                        list.add(i);
                    }
                } else {
                    stack.push(new SignIndex(arr[i], i));
                }
            }
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop().index);
        }
        System.out.println(list);
        int[] transArr = new int[len];
        for (Integer i : list) {
            transArr[i] = 1;
        }
        // 至此问题转化为求数组transArr中连续0的最长长度
        int[][] dp = new int[len][len];
        int maxLen = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j && transArr[j] == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (transArr[i] == transArr[j] && transArr[j] == 0) {
                    if (dp[i + 1][j - 1] == j - i - 1) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        // 说明dp[i + 1][j - 1]里不是连续的0
                        dp[i][j] = 0;
                    }
                    maxLen = Math.max(maxLen, dp[i][j]);
                    continue;
                }
                if (transArr[i] != transArr[j]) {
                    if (transArr[i] == 0) {
                        if (dp[i + 1][j - 1] == j - i - 1) {
                            dp[i][j - 1] = dp[i + 1][j - 1] + 1;
                        } else {
                            dp[i][j - 1] = 0;
                        }
                    } else {
                        if (dp[i + 1][j - 1] == j - i - 1) {
                            dp[i + 1][j] = dp[i + 1][j - 1] + 1;
                        } else {
                            dp[i + 1][j] = 0;
                        }
                    }
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen;
    }

    public int getType(char c) {
        return (c == '(' || c == '[' || c == '{') ? -1 : 1;
    }

    public boolean isMatch(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }
}

class SignIndex {
    char sign;
    int index;

    public SignIndex(char sign, int index) {
        this.index = index;
        this.sign = sign;
    }
}


