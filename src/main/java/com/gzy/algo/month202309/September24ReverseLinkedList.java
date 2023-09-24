package com.gzy.algo.month202309;

public class September24ReverseLinkedList {

    /**
     * Given the head of a singly linked list,
     * reverse the list, and return the reversed list.
     *
     *
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {


        return process(head, null);
    }




    private ListNode process(ListNode node, ListNode pre) {

        if (node == null){
            return pre;
        }

        ListNode next = node.next;

        node.next = pre;

        return process(next, node);
    }


    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
