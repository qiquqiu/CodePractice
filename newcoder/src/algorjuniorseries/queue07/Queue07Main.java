package algorjuniorseries.queue07;

import java.util.Scanner;

public class Queue07Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue queue = new Queue();
        while (in.hasNextLine()) {
            String[] arr = in.nextLine().split(" ");
            if (arr[0].equals("push")) {
                queue.push(Integer.parseInt(arr[1]));
            } else if (arr[0].equals("pop")) {
                queue.pop();
            } else if (arr[0].equals("front")) {
                queue.front();
            }
        }
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node() {
    }
}

class LinkedList {
    Node head; // 不存值
    Node tail; // 指向末尾
    /*
     * 解题过程：
     * 初步写完代码之后，push的时间复杂度是O(n)，pop和front的时间复杂度
     * 都是O(1)，可是即便是O(n)，push的时间复杂度还是太高了，所以需要优化。
     * 从实现环形链表的时候引入的length启发，我们引入一个指针总是指向队尾，
     * 并当且仅当在push操作，即队尾改变的时候，直接根据指针定位，再后移一位指针
     * 同样也实现了push的O(1)的时间复杂度!!!
     *
     * */

    public LinkedList() {
        head = new Node(0);
    }

    // push方法：将数据添加到队列尾
    public void push(int x) {
        if (head.next == null) {
            head.next = new Node(x);
            tail = head.next;
            return;
        }
        tail.next = new Node(x);
        tail = tail.next;
    }

    // pop方法：弹出（删除）队列头部的数据
    public void pop() {
        if (head.next == null) {
            System.out.println("error");
            return;
        }
        System.out.println(head.next.val);
        head.next = head.next.next;
    }

    // front方法：仅查看队列头部数据，不弹出
    public void front() {
        if (head.next == null) {
            System.out.println("error");
            return;
        }
        System.out.println(head.next.val);
    }
}

class Queue {
    LinkedList list; // 通过维护一个链表来实现队列

    public Queue() {
        list = new LinkedList();
    }

    public void push(int x) {
        list.push(x);
    }

    public void pop() {
        list.pop();
    }

    public void front() {
        list.front();
    }
}