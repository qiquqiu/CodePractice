package liststackqueue.lc225;

import java.util.LinkedList;
import java.util.Queue;

public class Solution225 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        int top = stack.top();
        System.out.println("Top: " + top);
        int pop = stack.pop();
        System.out.println("Pop: " + pop);
        boolean empty = stack.empty();
        System.out.println("Empty: " + empty);
    }
}

// 要求：使用队列模拟栈
// 与用栈模拟队列的思路一样,这里是做题所以没有添加非空检查
class MyStack {
    Queue<Integer> queue;
    Queue<Integer> help_queue;

    public MyStack() {
        queue = new LinkedList<>();
        help_queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        move(queue, help_queue, 1);
        int popVal = queue.poll();
        move(help_queue, queue, 0);
        return popVal;
    }

    public int top() {
        move(queue, help_queue, 1);
        int topVal = queue.poll();
        move(help_queue, queue, 0);
        queue.add(topVal);
        return topVal;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    private void move(Queue<Integer> from, Queue<Integer> to, int flag) {
        int priLen = from.size();
        // 如果flag是0，就说明是进行把辅助队列中的元素全部重新存到主队列中
        // 如果flag是1，就说明是进行把主队列中的n-1个元素存到辅助队列中
        for (int i = 0; i < priLen - flag; i++) {
            to.add(from.poll());
        }
    }
}