package algorjuniorseries.queue08;

import java.util.Scanner;

public class Queue08Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        // 为了简便，这里就直接使用链表创建其实例了
        // 不再用一个类来包装它了
        LinkedList queue = new LinkedList(size);
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

/*
 * 此次的队列不仅仅是实现成了环形队列
 * 还结合了练习07的思考：将“将数据添加到队列末尾”的方法的
 * 时间复杂度也降低为O(1);而且还支持自定义最大容量，根据长度
 * 来判断队列是否满或者是否空;此外，由于将“将数据添加到队列末尾”的方法的
 * 时间复杂度也降低为O(1)需要引入tail，而且环化队列同样需要引入tail
 * 所以要关注这两种使用是否冲突，事实证明并未冲突
 *
 * */

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

class LinkedList {
    Node head;
    Node tail;
    int len; // 当前队列的长度（节点数目）
    int size; // 当前队列规定的最大长度

    public LinkedList(int size) {
        this.size = size;
        head = new Node(0);
    }

    public boolean isFull() {
        // 环形队列以len作为满/空标准而非head的next内容情况
        return len == size;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public void connect() {
        if (tail != null) {
            tail.next = head;
        }
    }

    public void disconnect() {
        tail.next = null;
    }

    // 将数据加入到队尾，若已满则输出full，否则不输出
    public void push(int x) {
        if (isFull()) {
            System.out.println("full");
            return;
        }
        if (head.next == null) {
            // 此情况无需解连接
            head.next = new Node(x);
            tail = head.next;
            // 连接
            tail.next = head;
            len++;
            return;
        }
        // 解除连接
        disconnect();
        tail.next = new Node(x);
        len++;
        tail = tail.next;
        // 连接
        connect();
    }

    // 输出对首元素，若队列为空则输出null
    public void pop() {
        if (isEmpty()) {
            System.out.println("empty");
            return;
        }
        // 必须先解除连接，因为若只有2个节点
        // 则head.next.next并不为null
        // 或者只有1个节点，也会出现空指针问题
        disconnect();
        System.out.println(head.next.val);
        len--;
        head.next = head.next.next;
        connect();
    }

    public void front() {
        if (isEmpty()) {
            System.out.println("empty");
            return;
        }
        System.out.println(head.next.val);
    }
}