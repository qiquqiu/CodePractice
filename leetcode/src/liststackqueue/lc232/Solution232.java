package liststackqueue.lc232;

import java.util.Stack;

public class Solution232 {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        int peek = queue.peek();
        System.out.println("Peek: " + peek); // 输出：Peek: 1
        int pop = queue.pop();
        System.out.println("Pop: " + pop); // 输出：Pop: 1
        boolean empty = queue.empty();
        System.out.println("Empty: " + empty); // 输出：Empty: false
    }
}

// 要求：用两个栈模拟队列
class MyQueue {
    // 通过维护两个栈，实现队列
    private Stack<Integer> push_stack;
    private Stack<Integer> pop_stack;

    public MyQueue() {
        push_stack = new Stack<>();
        pop_stack = new Stack<>();
    }

    public void push(int x) {
        push_stack.push(x);
    }

    public int pop() {
        move(push_stack, pop_stack);
        int popVal = pop_stack.pop();
        move(pop_stack, push_stack);
        return popVal;
    }

    public int peek() {
        move(push_stack, pop_stack);
        int peekVal = pop_stack.peek();
        move(pop_stack, push_stack);
        return peekVal;
    }

    public boolean empty() {
        return push_stack.isEmpty();
    }

    // 将stack1的所有元素pop出来再push进入stack2
    private void move(Stack<Integer> stack1, Stack<Integer> stack2) {
        int priLen = stack1.size(); // 这是一个常见的细节
        for (int i = 0; i < priLen; i++) {
            stack2.push(stack1.pop());
        }
    }
}
