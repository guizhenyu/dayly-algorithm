package com.gzy.algo.month202309;

public class September20LongestIncreasingSubsequence {


    /**
     * Given an integer array nums, return the length of the longest strictly
     * increasing subsequence.
     *
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums){
        return process(nums, 1, 0);
    }

    public int process(int[] nums, int index, int preIndex){
        if (index == nums.length){
            return 1;
        }

        int ans = process(nums, index + 1, preIndex);
        if (nums[index] > nums[preIndex]){
            ans = Math.max(ans, process(nums, index + 1, index) + 1);
        }else {
            ans = Math.max(ans, process(nums, index + 1, index));
        }

        return ans;
    }

    public int dp(int[] nums){
        int N = nums.length;


    }
}
