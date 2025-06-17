package algorjuniorseries.stack03;

import java.util.Stack;

public class Stack03Solution {
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char item : s.toCharArray()) {
            if (item == '[') {
                stack.push(']');
            } else if (item == '{') {
                stack.push('}');
            } else if (item == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || stack.pop() != item) {
                // 如果 还有数据 并且不是 [ { (  ,那么stack就是空的，不符合要求
                // 或者弹出的元素不等于当前的 也不是
                return false;
            }
        }
        // 最终是空，即全部匹配完毕，等价于返回true
        // 最终不为空，说明未全部匹配完毕，等价于返回false
        return stack.isEmpty();
    }
}
// ()[]{}
// ([{}]) ()...  原来的做法只考虑到了上面两种情况
// [()[[]()]]   ->   这是原来的做法所忽略的一种情况