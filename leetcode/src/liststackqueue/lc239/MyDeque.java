package liststackqueue.lc239;

import java.util.LinkedList;

public class MyDeque {
    // 实现单调队列（简化版）
    // 这里自己来在最外部包装一个单调队列类，主要是为了更好的理解add时候的
    // 保持单调的原理，我们这里并没有考虑安全性；实际上，我们这里底层还是通过维护一个
    // 链表来实现单调队列，因为这里更多的涉及到的是增删操作，所以我们用链表实现

    // 值得注意的是，javaAPI中并没有为我们实现“单调队列”，我们需要自己实现
    // 注意其实就在于重构它的外部add逻辑
    private final LinkedList<Integer> deque;

    public MyDeque() {
        deque = new LinkedList<>();
    }

    // 从队列头取出数据
    public int poll() {
       return deque.poll();
    }

    // 查看队列头部数据
    public int peekFirst() {
        return deque.peekFirst();
    }

    // 从队列尾添加数据
    public void add(int x) {
        if (deque.isEmpty()) {
            deque.add(x);
            return;
        }

        while (x > peekLast() && !deque.isEmpty())  {
            pollLast();
        }
        deque.add(x);
    }

    // 查看队列尾部数据
    public int peekLast() {
        if (!deque.isEmpty()) {
            return deque.peekLast();
        }
        return Integer.MIN_VALUE;
    }

    public void pollLast() {
        deque.pollLast();
    }
}
