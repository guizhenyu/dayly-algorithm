package com.gzy.algo.day20230820;

public class RemoveDuplicatesFromSortedArray {
    /**
     * Give an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique
     * element appears only once. The relative order of the elements should be kept the same. Then return the number
     * of unique element in nums.
     * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
     * Change the array nums such that the first k elements of nums contain the unique elements in the order they were
     * present in nums initially. Then remaining elements of nums are not important as well as the size of nums.
     * return k.
     *
     * Constraints:
     * 1 <= nums.length <= 3 * 10^4
     * -100 <= nums[i] <= 100
     * nums is sorted in non-decreasing order.
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int ans = 0;
        int preNum = nums[ans];
        int fast = 1;

        while (fast < nums.length){
            if (preNum != nums[fast]){
                nums[++ans] = nums[fast];
                preNum = nums[ans];
            }
            fast++;
        }

        return ans + 1;
    }


}
