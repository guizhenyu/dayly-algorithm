package com.gzy.algo.month202401;

import java.util.Stack;

public class January22DailyTemperatures {


    /**
     * Given an array of integers temperatures represents the daily temperatures,
     * return an array answer such that answer[i] is
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);

        int[] ans = new int[temperatures.length];
        for (int i = 1; i < temperatures.length; i++){
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                Integer pop = stack.pop();
                ans[pop] = i - pop;
            }
            stack.push(i);
        }



        return ans;
    }
}
