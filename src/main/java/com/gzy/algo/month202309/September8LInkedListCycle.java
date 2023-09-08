package com.gzy.algo.month202309;

public class September8LInkedListCycle {

    /**
     * Given head, the head of a linked list, determined if the linked list has a cycle in it.
     * There is a cycle in a linked list if there is some node can reached again by continuously
     * following the next pointer.
     * Return true, if there is a cycle in the linked list.Otherwise, return false.
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }

        ListNode fastNode = head.next.next;

        while (head != null && fastNode != null){

            if (head == fastNode){
                return true;
            }

            head = head.next;

            if (fastNode.next == null){
                return false;
            }

            fastNode = fastNode.next.next;
        }

        return false;
    }


    public class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }


    }
}
