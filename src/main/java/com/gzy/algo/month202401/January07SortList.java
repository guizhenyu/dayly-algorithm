package com.gzy.algo.month202401;

public  class January07SortList {



    public static class ListNode {
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
        int startStep = 1;
        int len = 0;
        ListNode nodeTravel = head;
        while (nodeTravel != null){
            len++;
            nodeTravel = nodeTravel.next;
        }

        ListNode headSentinel = new ListNode(0);
        headSentinel.next = head;
        while (startStep < len){
            ListNode pre = headSentinel;
            nodeTravel = headSentinel.next;
            while (nodeTravel != null){
                // 每次取两个步长的 链表进行合并
                ListNode firstNode = nodeTravel;
                ListNode secondNode = cutOffWithLen(firstNode, startStep);
                ListNode nextNode = cutOffWithLen(secondNode, startStep);
                ListNode mergeHead = merge(firstNode, secondNode);
                pre.next = mergeHead;
                pre = getTail(mergeHead);
                nodeTravel = nextNode;
            }

            startStep <<= 1;
        }

        return headSentinel.next;

    }

    private ListNode getTail(ListNode merge) {

        if (merge == null){
            return null;
        }

        while (merge.next != null){
            merge = merge.next;
        }

        return merge;
    }

    public ListNode cutOffWithLen(ListNode node, int len){
        if (node == null){
            return null;
        }
        ListNode nextNode = node;
        while (len > 1 && nextNode != null){
            nextNode = nextNode.next;
            --len;
        }

        if (nextNode != null){
            ListNode temp = nextNode.next;
            nextNode.next = null;
            nextNode = temp;

        }

        return nextNode;
    }

    public ListNode merge(ListNode node1, ListNode node2){
        ListNode headSentinel = new ListNode(0);
        ListNode pre = headSentinel;

        while (node1 != null && node2 != null){

            if (node1.val < node2.val){
                pre.next = node1;
                node1 = node1.next;
            }else {
                pre.next = node2;
                node2 = node2.next;
            }
            pre = pre.next;

        }

        if (node1 != null){
            pre.next = node1;
        }

        if (node2 != null){
            pre.next = node2;
        }


        return headSentinel.next;
    }


    public static void main(String[] args) {


        ListNode listNode1 = new ListNode(4);


        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(1);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(3);
        listNode3.next = listNode4;

        January07SortList january07SortList = new January07SortList();
        ListNode listNode = january07SortList.sortList(listNode1);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


}
