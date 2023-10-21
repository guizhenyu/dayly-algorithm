package com.gzy.algo.month202310;

import java.util.Stack;

public class October18TrappingRainWater {

    /**
     * Given an non-negative integers representing an elevation map where the width of each bar is 1,
     * compute how much water it can trap after raining.
     *
     *
     *
     * @param height
     * @return
     */
    public int trap(int[] height){

        if (height == null || height.length <= 2){
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int ans = 0;
        for (int i = 0; i < height.length; i++){
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]){
                Integer index = stack.pop();
                if (height[index] == height[i]){
                    break;
                }
                if (!stack.isEmpty()){
                    int h = Math.min(height[i], height[stack.peek()]);
                    ans += (i - stack.peek() - 1) * (h - height[index]);
                }
            }

            stack.push(i);

        }
        return ans;
    }

}
