package com.gzy.algo.month202309;

public class September4IntersectionOfTwoLinkedList {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if (headB == null || headA == null){
            return null;
        }

        ListNode pA = headA, pB = headB;

        while(pA != pB){
            pA = pA == null? headB : pA.next;
            pB = pB == null? headA : pB.next;
        }
        return pA;

    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}


