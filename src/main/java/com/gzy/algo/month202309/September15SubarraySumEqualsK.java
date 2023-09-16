package com.gzy.algo.month202309;

public class September15SubarraySumEqualsK {

    /**
     * Given an array of integers nums and integer k, return the total number of subArrays whose sum equals to k.
     *
     * A subArray is a contiguous non-empty sequence of elements within an array.
     *
     *
     * @param nums
     * @param k
     * @return
     */

    public int subarraySum(int[] nums, int k){
        int N = nums.length;
        int[] sums = new int[N];
        sums[0] = nums[0];
        for (int i = 1; i < N; i++){
            sums[i] = sums[i - 1] + nums[i];
        }
        int ans = 0;
        int left = 0;


        while(left < N){
            int leftBound = left == 0? 0 : sums[left - 1];
            for (int i = left; i < N; i++){

                if (sums[i] - leftBound == k){
                    ans++;
                }

            }
            left++;
        }

        return ans;
    }
}
