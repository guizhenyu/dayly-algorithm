package com.gzy.algo.month202309;

public class September9LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }

        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode != null){
            slowNode = slowNode.next;

            if (fastNode.next == null){
                return null;
            }
            fastNode = fastNode.next.next;

            if (slowNode == fastNode){
                slowNode = head;
                while (slowNode != fastNode){
                    slowNode = slowNode.next;
                    fastNode = fastNode.next;
                }
                return fastNode;
            }
        }

        return null;
    }

    public class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }


    }
}
