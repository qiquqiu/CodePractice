package liststackqueue.lc20;

import java.util.Stack;

public class Solution20 {
    public boolean isValid(String s) {
        // "( {} [ { } ] )"
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                if (getType(c) == 1) {
                    return false;
                }
                stack.push(c);
            } else {
                if (getType(c) == 1) {
                    // 额这个参数顺序要注意正确
                    if (!isMatch(stack.pop(), c)) {
                        return false;
                    }
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }

    public int getType(char c) {
        return (c == '(' || c == '[' || c == '{') ? -1 : 1;
    }

    public boolean isMatch(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }
}
