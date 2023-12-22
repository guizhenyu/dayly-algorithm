package com.gzy.algo.month202312;

public class December13CopyListWithRandomPointer {


    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        for (Node next = head; next != null; next = next.next.next){
            Node node = new Node(next.val);
            node.next = next.next;
            node.random = next.random;
            next.next = node;
        }


        for (Node node = head.next; node != null; node = node.next.next){
            if(node.random != null){
                node.random = node.random.next;
            }

            if(node.next == null){
                break;
            }
        }

        Node newHead = head.next;


        for (Node node = head, newNode = newHead; node != null; node = node.next, newNode = newNode.next){

            if (node.next != null){
                node.next = node.next.next;
            }

            if (newNode.next != null){
                newNode.next = newNode.next.next;
            }

        }


        return newHead;




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
