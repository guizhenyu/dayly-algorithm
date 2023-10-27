package com.gzy.algo.month202310;

public class October27PalindromeLinkedList {


    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    /**
     * Given the head of a singly linked list,
     * return true if it is a palindrome or false otherwise.
     *
     */

    public boolean idPalindrome(ListNode head) {

        if (head == null){
            return false;
        }

        int n = 1;
        ListNode node = head.next;
        while (node!= null){
            n++;
            node = node.next;
        }

        int mid = n >> 1;

        int index = 0;

        node = head;
        ListNode pre = null;
        ListNode next = null;
        while (index < mid){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
            index++;
        }

        if (mid * 2 != n){
            node =  node.next;
        }

        while (index >= 0){

            if (pre.val != node.val){
                return false;
            }

            pre = pre.next;
            node = node.next;

            index--;
        }

        return true;

    }
}
