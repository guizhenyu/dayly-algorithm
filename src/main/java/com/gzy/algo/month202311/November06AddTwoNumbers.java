package com.gzy.algo.month202311;

public class November06AddTwoNumbers {
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

          ListNode ans = null;
          ListNode next = null;
          int preNum = 0;
          while (l1 != null ||  l2 != null){
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null? 0 : l2.val) + preNum;

            int num = sum % 10;

            if (ans == null){
                ans = new ListNode(num);
                next = ans;
            }else {
                next.next = new ListNode(num);
                next = next.next;
            }
            preNum = sum / 10;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
          }

          if (preNum > 0){
              next.next = new ListNode(preNum);
          }
          return ans;

    }

    public static void main(String[] args) {


    }
}
