package algorjuniorseries.linkedlist09;

import java.util.Scanner;

public class linkedlist09 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in) ;
        sca.nextLine() ;
        LinkedList list = new LinkedList() ;
        while (sca.hasNextLine()) {
            String[] arr = sca.nextLine().split(" ") ;
            if (arr[0].equals("insert")) {
                list.insert(Integer.parseInt(arr[1]), Integer.parseInt(arr[2])) ;
            } else {
                list.delete(Integer.parseInt(arr[1])) ;
            }
        }
        list.list();
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node() {}
}

class LinkedList {
    Node head;

    public LinkedList() {}

    // 将y插入在第一个值为x的节点之前
    public void insert(int x, int y) {
        if (head == null) {
            head = new Node(y);
            return;
        }
        // 如果是头节点要特殊处理一下
        if (head.val == x) {
            Node newNode = new Node(y);
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.val != x) {
            temp = temp.next;
        }
        if (temp.next == null) {
            temp.next = new Node(y);
        } else {
            Node newNode = new Node(y);
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // 删除第一个值为x的节点
    public void delete (int x) {
        if (head == null) {
            return;
        }
        // 如果头节点就是x，要特殊处理
        // （此链表头节点是有值的，所以改变后要进行处理）
        if (head.val == x) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.val != x) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next =  temp.next.next;
        }
    }

    public void list() {
        if (head == null) {
            System.out.print("NULL");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}