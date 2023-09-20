package com.gzy.algo.month202309;

import java.util.ArrayList;
import java.util.List;

public class September20Subsets {


    /**
     * Given an integer array nums of unique Elements, return all possible subsets(the power set).
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     *
     */
    public List<List<Integer>> subsets(int[] nums){
        /**
         *
         *
         */
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return ans;
        }
        List<Integer> curList = new ArrayList<>();

        process(nums, 0, curList, ans);
        return ans;
    }

    public void process(int[] nums, int index, List<Integer> curList, List<List<Integer>> ans){
        if (index == nums.length){
            ans.add(curList);
            return;
        }
        List<Integer> curi = new ArrayList<>(curList);
        List<Integer> cur2 = new ArrayList<>(curList);
        cur2.add(nums[index]);
        process(nums, index + 1, curi, ans);
        process(nums, index + 1, cur2, ans);
    }
}
