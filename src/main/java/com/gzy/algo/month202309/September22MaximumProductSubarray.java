package com.gzy.algo.month202309;

public class September22MaximumProductSubarray {

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
        int[] maxDp = new int[N];
        int[] minDp = new int[N];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        int maxAns = nums[0];

        for (int i = 1; i < N; i++){
            int num1 = nums[i] * maxDp[i - 1];
            int num2 = nums[i] * minDp[i - 1];
            maxDp[i] = Math.max(nums[i], Math.max(num1, num2));
            minDp[i] = Math.min(nums[i], Math.min(num1, num2));

            maxAns = Math.max(maxDp[i], maxAns);
        }

        return maxAns;
    }
}
