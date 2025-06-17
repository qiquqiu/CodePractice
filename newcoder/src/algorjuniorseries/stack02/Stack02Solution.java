package algorjuniorseries.stack02;

import java.util.Stack;

public class Stack02Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int n = pushA.length;
        //辅助栈
        Stack<Integer> s = new Stack<>();
        //遍历入栈的下标
        int j = 0;
        //遍历出栈的数组
        for (int i = 0; i < n; i++) {
            //入栈：栈为空或者栈顶不等于出栈数组
            while (j < n && (s.isEmpty() || s.peek() != popA[i])) {
                s.push(pushA[j]);
                j++;
            }
            //栈顶等于出栈数组
            if (s.peek() == popA[i])
                s.pop();
                //不匹配序列
            else
                return false;
        }
        return true;
    }
}
