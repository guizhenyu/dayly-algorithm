package com.gzy.algo.month202308.day20230819;

public class RotateArray {

    /**
     * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative
     * Follow up:
     * Try to come up with as many solutions as you can, there are at least 3 different ways to solve this problem .
     * Could you do it in-place with O(1) extra space?
     *
     * Constraints:
     *
     * 1 <= nums.length <= 10^5
     * -2^31 <= nums[i] <= 2^31 - 1
     * 0 <= k <= 10^5
     * @param nums
     * @param k
     */
    public void rotateArray(int[] nums, int k){
        int len = nums.length;
        k = k % len;
        reverse(nums, 0,  len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    public void reverse(int[] nums, int start, int end){

        while(start < end){
            int temp = nums[end];

            nums[end--] = nums[start];

            nums[start++] = temp;
        }

    }
}


