package com.gzy.algo.month202401;

public class January07SortList {



    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Given the head of a linked list, return the list after sorting it in ascending order.
     *
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head){
        /**
         * 采用归并的思想进行排序
         */
        if(head == null){
            return head;
        }
        ListNode headSentinal = new ListNode(0);
        headSentinal.next = head;
        int mergeStep = 1;
        int len = 1;
        ListNode next = head.next;
        while (next != null){
            len++;
            next = next.next;
        }
        ListNode pre = null;
        while (mergeStep < len){

            pre = headSentinal;
            next = headSentinal.next;
            while (next != null){
                ListNode head1 = next;

                for (int i = 1; i < mergeStep && next != null; i++){

                    next = next.next;
                }
                ListNode head2 = next.next;
                if (head2 == null){
                    break;
                }
                next.next = null;
                next = head2;
                for (int i = 1; i < mergeStep && next != null; i++){
                    next = next.next;
                }

                if (next != null){
                    ListNode temp = next.next;
                    next.next = null;
                    next = temp;
                }

                pre.next = merge(head1, head2);
                while (pre.next != null){
                    pre = pre.next;
                }
            }


            mergeStep = mergeStep << 1;
        }



        return headSentinal.next;
    }


    public ListNode merge(ListNode node, ListNode node1){
        ListNode headFlag = new ListNode();
        ListNode preTail = null;

        while (node != null && node1 != null){
            ListNode lessNode = null;
            if (node.val > node1.val){
                lessNode = node1;
                node1 = node1.next;
            }else {
                lessNode = node;
                node = node.next;
            }

            if (preTail == null){
                preTail = lessNode;
                headFlag.next = lessNode;
            }else {
                preTail.next = lessNode;
            }

        }

        while (node != null){
            preTail.next = node;
            preTail = node;
            node = node.next;

        }


        while (node1 != null) {
            preTail.next = node1;
            preTail = node1;
            node1 = node1.next;
        }

        return headFlag.next;
    }


}
