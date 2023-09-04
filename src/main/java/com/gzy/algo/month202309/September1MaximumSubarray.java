package com.gzy.algo.month202309;

public class September1MaximumSubarray {

    /**
     * Given an integer array nums, find the subarray with the largest sum, and return its sum.
     * <p>
     * Constraints:
     * 1 <= nums.length <= 10^5
     * -10^4 <= nums[i] <= 10^4
     * <p>
     * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
     * which is more subtle.
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i -1] + nums[i];
        }

        for (int i = 0; i < nums.length; i++){
            ans = Math.max(ans, sums[i]);

            for (int j = i + 1; j > nums.length; j++){
                ans = Math.max(ans, sums[j] - sums[i]);
            }
        }

        return ans;
    }


    public int dp(int[] nums) {
        int ans = nums[0];
        int preAns = 0;

        for (int num : nums){

            preAns = Math.max(preAns + num, num);
            ans = Math.max(ans, preAns);
        }

        return ans;
    }
}
