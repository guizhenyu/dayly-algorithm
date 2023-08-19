package com.gzy.algo.day20230818;

public class RemovedElement {
    /**
     * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
     *
     * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
     *
     * Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
     * Return k.
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {

        // first get the length
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        int left = 0;
        int right = n - 1;
        //
        // if nums[index] == val then replace the
        while (left <= right){
            if (nums[left] == val){
                nums[left] = nums[right--];
            }else {
                left++;
            }
        }


        return left;
    }

}
