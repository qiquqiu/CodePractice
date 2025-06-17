package liststackqueue.lc622;

public class MyCircularQueue {
    private CircleArrQueue622 queue;

    public MyCircularQueue(int k) {
        queue = new CircleArrQueue622(k + 1);
    }

    public boolean enQueue(int value) {
        return queue.enter(value);
    }

    public boolean deQueue() {
        return queue.delete();
    }

    // 从队首获取元素。如果队列为空，返回 -1
    public int Front() {
        return queue.showFront();
    }

    // 获取队尾元素。如果队列为空，返回 -1
    public int Rear() {
        return queue.showRear();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean isFull() {
        return queue.isFull();
    }
}

class CircleArrQueue622 {
    private int maxSize;
    private int[] arr;
    private int front;
    private int rear;

    public CircleArrQueue622(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean enter(int n) {
        if (isFull()) {
            return false;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
        return true;
    }

    public boolean delete() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % maxSize;
        return true;
    }

    public int showFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    public int showRear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(rear - 1 + maxSize) % maxSize];
    }
}
