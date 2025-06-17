package liststackqueue.lc155;

import java.util.ArrayList;
import java.util.LinkedList;

public class MinStack {
    // 用链表实现栈
    LinkedList<Integer> list;
    ArrayList<Integer> arr;

    public MinStack() {
        list = new LinkedList<>();
        arr = new ArrayList<>();
    }

    // 末尾为栈顶
    public void push(int val) {
        list.add(val);
        arr.add(val);
        // 逆天新特性，函数引用代替lambada表达式
        arr.sort(Integer::compare);
    }

    public void pop() {
        if (list != null) {
            arr.remove(arr.indexOf(list.getLast()));
            list.removeLast();
        }
    }

    public int top() {
        if (list != null) {
            return list.getLast();
        }
        return -1;
    }

    // 题目说要这个函数时间复杂度是O(1)
    public int getMin() {
        if (list != null) {
            return arr.getFirst();
        }
        return Integer.MAX_VALUE;
    }
}
