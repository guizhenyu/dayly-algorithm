package com.gzy.algo.month202312;

public class December13CopyListWithRandomPointer {


    public Node copyRandomList(Node head) {
        return null;
    }


    public static void main(String[] args) {

        Node node0 = new Node(7);

        Node node1 = new Node(13);

        Node node2 = new Node(11);


        Node node3 = new Node(10);

        Node node4 = new Node(1);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        node1.random = node0;
        node2.random = node4;
        node3.random = node2;
        node4.random = node0;

        December13CopyListWithRandomPointer fn = new December13CopyListWithRandomPointer();
        Node node = fn.copyRandomList(node0);
        System.out.println(node);
    }
}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
