package com.gzy.algo.month202311;

public class November24SwapNodesInPairs {


    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = head.next;


        ListNode next = newHead.next;

        newHead.next = head;
        head.next = next;

        while (head.next != null && head.next.next != null){
            next = head.next;
            head.next = next.next;
            next.next = head.next.next;
            head.next.next = next;

            head = head.next.next;

        }



        return newHead;
    }
}
