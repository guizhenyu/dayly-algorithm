package com.gzy.algo.month202310;

import java.util.Deque;
import java.util.LinkedList;

public class October24SlidingWindowMaximum {


    public int[] maxSlidingWindow(int[] nums, int k){

        Deque<Integer> deque = new LinkedList<>();

        int len = nums.length;

        int[] ans = new int[len - k + 1];

        for (int i = 0; i < k; i++){
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
        }
        ans[0] = nums[deque.peekFirst()];


        for (int i = k; i < len; i++){
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);

            while (!deque.isEmpty() && deque.peekFirst() < (i - k + 1)){
                deque.pollFirst();
            }

            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
