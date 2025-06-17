package liststackqueue.lc622;

public class Main622 {
    public static void main(String[] args) {
        MyCircularQueue mq = new MyCircularQueue(3);
        System.out.println(mq.enQueue(1));
        System.out.println(mq.enQueue(2));
        System.out.println(mq.enQueue(3));
        System.out.println(mq.enQueue(4));
        System.out.println(mq.Rear());
        System.out.println(mq.isFull());
        System.out.println(mq.deQueue());
        System.out.println(mq.enQueue(4));
        System.out.println(mq.Rear());
    }
}
