package com.gzy.algo.month202311;

public class November08FirstMissingPositive {


    /**
     * Given an unsorted integer array nums, return the smallest missing positive integer.
     * You must implement an algorithm that run in O(n) time and uses O(1) auxiliary space.
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums){
        int n = nums.length;

        for(int i = 0; i < n; i++){
            if (nums[i] <= 0){
                nums[i] = n + 1;
            }
        }
        // mark  num[index] to negative value if num[index] > 0 and index < n
        // every value of nums represents
        // 数组nums的每个数, 映射到nums的索引,
        for (int i = 0 ; i < n; i++){

            int index = Math.abs(nums[i]);
            if (index <

                    n && nums[index - 1] > 0){
                nums[index - 1] = -nums[index - 1];
            }
        }

        for (int i = 0 ; i < n; i++){
            if (nums[i] > 0){
                return i + 1;
            }
        }

        return n + 1;

    }
}
