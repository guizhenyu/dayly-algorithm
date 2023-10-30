package com.gzy.algo.month202310;

public class October28MergeTwoSortedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * You are given the heads of two sorted linked lists list1 and list2.
     * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
     * Return the head of the merged linked list.
     *
     *
     * @param listNode1
     * @param listNode2
     * @return
     */
    public ListNode mergerTwoLists(ListNode listNode1, ListNode listNode2){
        ListNode head = new ListNode(-1);
        ListNode next = head;

        while (listNode1 != null && listNode2 != null){
            if (listNode1.val < listNode2.val){
                next.next = listNode1;
                listNode1 = listNode1.next;
            }else {
                next.next = listNode2;
                listNode2 = listNode2.next;
            }
            next = next.next;
        }

        if (listNode1 != null){
            next.next = listNode1;
        }


        if (listNode2 != null){
            next.next = listNode2;
        }

        return head.next;
    }
}
