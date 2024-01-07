package com.gzy.algo.month202401;

import java.util.Stack;

public class January06ReverseNodeInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode headFlag = null;
        ListNode preTail = null;
        int left = k;

        while (head != null) {
            if (left == 0) {
                ListNode top = stack.pop();
                ListNode pre = top;
                ++left;
                while (left <= k && !stack.isEmpty()) {
                    ++left;
                    ListNode next = stack.pop();
                    pre.next = next;
                    pre = next;
                }
                if (headFlag == null) {
                    headFlag = top;
                }
                if (preTail == null) {
                    preTail = pre;
                } else {
                    preTail.next = top;
                }
                preTail = pre;
            }
            stack.push(head);
            head = head.next;
            --left;
        }


        if (!stack.isEmpty()) {
            if (left == 0) {
                ListNode top = stack.pop();
                ListNode pre = top;
                ++left;
                while (left <= k && !stack.isEmpty()) {
                    ++left;
                    ListNode next = stack.pop();
                    pre.next = next;
                    pre = next;
                }
                if (headFlag == null) {
                    headFlag = top;
                }
                pre.next = null;
                if (preTail == null) {
                    preTail = pre;
                } else {
                    preTail.next = top;
                }

            } else {
                ListNode next = stack.pop();
                while (!stack.isEmpty()) {
                    ListNode pop = stack.pop();
                    pop.next = next;
                    next = pop;
                }
                if (headFlag == null) {
                    headFlag = next;
                } else {
                    preTail.next = next;
                }
            }
        }

        return headFlag;

    }


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
}
