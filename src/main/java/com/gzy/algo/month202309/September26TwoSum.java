package com.gzy.algo.month202309;

import java.util.HashMap;
import java.util.Map;

public class September26TwoSum {

    /**
     * easy
     *
     *
     * Given an array of integers nums and integer target,
     * return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution,
     * and you may not use the same element twice.
     *
     * You can return the answer in any order.
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target){
        int[] ans  = new int[2];

        Map<Integer, Integer> recordMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++){
            int numF = target - nums[i];
            if (recordMap.containsKey(numF)){
                ans[0] = recordMap.get(numF);
                ans[1] = i;
                return ans;
            }else {
              recordMap.put(nums[i], i);
            }
        }

        return null;
    }
}
