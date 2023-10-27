package com.gzy.algo.month202310;

public class October26RotateArray {

    /**
     * You are given an integer array nums, rotate the array to the right in k steps, and K is non-negative.
     *
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k){

       int len = nums.length;
       k %= len;
       reverse(nums, 0, len - 1);
       reverse(nums,0, k - 1);
       reverse(nums,k , len - 1);

    }

    public void reverse(int[] nums, int start, int end){

        while (start < end){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }

    }
}
