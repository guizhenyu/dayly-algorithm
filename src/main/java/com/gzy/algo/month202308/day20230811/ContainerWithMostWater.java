package com.gzy.algo.month202308.day20230811;

import java.util.Stack;

public class ContainerWithMostWater {
    //https://leetcode.cn/problems/container-with-most-water/

    public int maxArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackIndex = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++){

            if (stack.isEmpty()){
                stack.push(height[i]);
                stackIndex.push(i);
            }else {
                int h = 0;
                int index = 0;
                while (!stack.isEmpty() && stack.peek() < height[i]){
                    h = stack.pop();
                    index =  stackIndex.pop();
                }

                if (stack.isEmpty()){
                    ans = Math.max(ans, h * (i - index));
                }
                stack.push(height[i]);
                stackIndex.push(i);
            }
        }

        int h = stack.pop();
        int index = stackIndex.pop();

        while (!stack.isEmpty()){
            ans =Math.max(ans, h * (index - stackIndex.peek()));
            h = stack.pop();
            index = stackIndex.pop();
        }


        return ans;
    }

    /**
     *  use double pointer
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int n = height.length;

        int l = 0;
        int r = n - 1;
        int ans = 0;

        while (l < r){
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]){
                l++;
            }else {
                r--;
            }
        }

        return ans;
    }
}
