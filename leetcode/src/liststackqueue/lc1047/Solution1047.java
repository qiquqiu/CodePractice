package liststackqueue.lc1047;

public class Solution1047 {
    // 输入："abbaca"
    // 输出："ca"
    public String removeDuplicates(String s) {
        char[] cs = s.toCharArray();
        MyStack stack = new MyStack();
        for (char c : cs) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                // push之前先peek
                char top = stack.peek();
                if (top == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.toString();
    }
}

class MyStack {
    // 通过维护一个StringBuilder来构建一个只能存储字符类型的栈
    private StringBuilder sb;

    public MyStack() {
        sb = new StringBuilder();
    }

    public void push(char c) {
        sb.append(c);
    }

    public char pop() {
        char c = sb.charAt(sb.length() - 1);
        sb.setLength(sb.length() - 1);
        return c;
    }

    public char peek() {
        char c = sb.charAt(sb.length() - 1);
        return c;
    }

    public boolean isEmpty() {
        return sb.isEmpty();
    }

    public int getLength() {
        return sb.length();
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
