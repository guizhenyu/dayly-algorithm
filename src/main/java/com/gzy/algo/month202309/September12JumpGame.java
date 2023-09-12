package com.gzy.algo.month202309;

public class September12JumpGame {


    /**
     * You are given an integer array nums. You are initially positioned at the array's first index, and each element in
     * the array represents your maximum jump length at that position.
     * Return true if you can reach the last index, or false otherwise.
     *
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums){
        int step = 1;
        for (int i = 0; i < nums.length - 1; i++){
            step = Math.max(step - 1, nums[i]);
            if (step == 0){
                return false;
            }
        }

        return true;
    }



}
