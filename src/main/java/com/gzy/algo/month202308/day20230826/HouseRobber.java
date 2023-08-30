package com.gzy.algo.month202308.day20230826;

public class HouseRobber {

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }
        int len  = nums.length;

        int[] dp = new int[len];
        // dp[0] = nums[0];
        int rob0 = nums[0];
        int rob1 = Math.max(nums[0], nums[1]);
        // dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < len; i++){
            int temp = rob1;
            rob1 = Math.max(rob1, rob0 + nums[i]);
            rob0 = temp;
            // dp[i] = Math.max(dp[i - 1], dp[i - 2] +  nums[i]);
        }



        return rob1;
    }
}
