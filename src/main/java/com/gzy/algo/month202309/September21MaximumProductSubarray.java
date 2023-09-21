package com.gzy.algo.month202309;

public class September21MaximumProductSubarray {

    /**
     * Given an integer array nums, find a subarray that has the largest product(multiply), and return the product.
     * The test cases are generated so that the answer will fit a 32-bit integer.
     *
     * Constraints:
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     *
     */
    public int maxProduct(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }

        int N = nums.length;


        return process(nums, 0, Integer.MIN_VALUE);
    }

    public int process(int[] nums, int index, int ans){

        if (index == nums.length){
            return ans;
        }

        int p1 = Math.max(process(nums, index + 1, ans * nums[index]), ans);

        int p2  = process(nums, index + 1, nums[index]);

        return  Math.max(p1, p2);
    }

    public int dp(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }

        int N = nums.length;
        int[] dp = new int[N];
        dp[N - 1] = nums[N - 1];
        for (int i = N - 2; i >= 0; i--){



        }

        return dp[0];
    }
}
