package liststackqueue.lc394;

import java.util.Stack;

public class Solution394 {
    // 本题主要就是这种递归的思路，这里是通过类似表达式求值的思路，利用递归解决括号嵌套问题
    // 不过比表达式求值（简单计算器）类题目要难一些，因为前者有逆波兰表达式的计算规则可以直接套用

    // 输入：s = "3[a2[c]3[d]]2[x]"
    // 输出："3*accddd2*x"
    // 结果：过了但是显然可以优化很多地方；
    public String decodeString(String s) {
        return cal(s);
    }

    private String cal(String str) {
        if (!str.contains("[")) {
            return str;
        }
        String allRet = "";
        int k = 0; // 题目保证k为正整数，即s.charAt(0)不可能是‘[’
        StringBuilder sb_num = new StringBuilder();
        StringBuilder sb_word = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9' && !flag) {
                // 由于题意不存在单独出现的数字，所以最终sb就是系数
                // 并且单独出现的字母一定在数字之前
                sb_num.append(c);
            } else {
                if (c == '[') {
                    stack.push(i);
                    flag = true;
                } else if (c == ']') {
                    if (stack.size() != 1) {
                        stack.pop();
                    } else {
                        if (!sb_num.isEmpty()) {
                            k = Integer.parseInt(sb_num.toString());
                        } else {
                            k = 0;
                        }
                        String nxt = cal(str.substring(stack.pop() + 1, i));
                        String ret = "";
                        for (int j = 0; j < k; j++) {
                            ret += nxt;
                        }
                        if (!sb_word.toString().isEmpty()) {
                            allRet += sb_word + ret;
                        } else {
                            allRet += ret;
                        }
                        sb_word.setLength(0);
                        sb_num.setLength(0);
                        flag = false;
                    }
                } else if (!flag) {
                    // 是直接出现的字母就直接添加结果
                    sb_word.append(c);
                }
            }
        }
        if (!sb_word.isEmpty()) {
            return allRet + sb_word;
        }
        return allRet;
    }
}
