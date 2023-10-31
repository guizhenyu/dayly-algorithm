package com.gzy.algo.month202310;

public class October29MergerKSortedList {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergerKSortedList(ListNode[] list){
        int maxValue =  10001;
        int[] counts = new int[maxValue * 2];
        if (list == null || list.length == 0){
            return null;
        }
        for (int i = 0 ; i < list.length; i++){
            ListNode node = list[i];
            while (node != null){
                counts[node.val + maxValue]++;
                node = node.next;
            }
        }
        ListNode ans = new ListNode(-1);
        ListNode next = ans;
        for (int i = 0; i < counts.length; i++){
            if (counts[i] > 0){
                while (counts[i] > 0){
                    next.next = new ListNode(i - maxValue);
                    next = next.next;
                    counts[i]--;
                }
            }
        }
        return ans.next;

    }

    public final static int num = 10;

    public static void main(String[] args) {
        October29MergerKSortedList ob = new October29MergerKSortedList();
//        ob.num = 11;

        System.out.println(10^4 + 1);
        System.out.println(October29MergerKSortedList.num);
    }




}
