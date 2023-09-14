package com.gzy.algo.month202309;

public class September14MinStack {

    /**
     * Design a stack that supports push, pop, top and retrieving the minimum element in constant time.
     * You must implement a solution with O(1) time complexity for each function.
     *
     *
     *
     */


    class MinStack {

        int capacity;

        int offset;
        int[] stack;

        int[] minStack;
        public MinStack() {
            capacity = 1 << 4;
            offset = 0;
            stack = new int[capacity];
            minStack = new int[capacity];
        }

        public void push(int val) {
            if (offset == capacity){
                capacity = capacity << 1;
                int[] newStack = new int[capacity];
                int[] newMinStack = new int[capacity];
                for (int i = 0; i < offset; i++){
                    newStack[i] = stack[i];
                    newMinStack[i] = minStack[i];
                }
                stack = newStack;
                minStack = newMinStack;
            }



            // 比较是否是最小值
            if (offset == 0){
                minStack[0] = val;
            }else {
                int min = minStack[offset - 1];
                minStack[offset] = Math.min(min, val);
            }

            stack[offset++] = val;
        }

        public void pop() {
            offset--;

            // 更新最小值


        }

        public int top() {
            return stack[offset - 1];
        }

        public int getMin() {
            return minStack[offset - 1];
        }
    }
}
