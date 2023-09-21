package com.gzy.algo.month202309;

public class September21LongestIncreasingSubsequence {


    /**
     * Given an integer array nums, return the length of the longest strictly
     * increasing subsequence.
     *
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        return process(nums, 1, 0,1);

    }

    public int process(int[] nums, int index, int preIndex, int len){
        if (index == nums.length){
            return len;
        }

        int ans = process(nums, index + 1, preIndex, len);
        if (nums[index] > nums[preIndex]){
            ans = Math.max(ans,process(nums, index + 1, index, ++len));
        }else {
            ans = Math.max(ans, process(nums, index + 1, index, 1));
        }

        return ans;
    }

    public int dp(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int N = nums.length;
        int[] dp = new int[N];
        dp[0] = 1;
        int  maxAns = 1;
        for (int i = 1; i < N; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxAns = Math.max(maxAns, dp[i]);
        }

        return maxAns;
    }

    public int greedAndDichotomy(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int N = nums.length;
        int[] dp = new int[N + 1];
        int len = 1;
        dp[len] = nums[0];
        for (int i = 1; i < N; i++){
            if (nums[i] > dp[len]){
                dp[++len] = nums[i];
            }else {
                int l = 1, r = len, mid = 0, position = 0;
                // because the dp array is monotone increasing.(单调递增)
                while (l <= r){
                    mid = (l + r) >> 1;
                    if (dp[mid] >= nums[i]){
                        r = mid - 1;
                    }else {
                        position = mid;
                        l = mid + 1;
                    }
                }
                dp[position + 1] = nums[i];
            }
        }
        return len;
    }
}
