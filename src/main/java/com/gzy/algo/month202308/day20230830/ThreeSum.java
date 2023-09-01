package com.gzy.algo.month202308.day20230830;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /**
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and
     * j != k, and nums[i] + nums[j] + nums[k] == 0.
     * Notice that the solution set must not contain duplicate triplets.
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int first = 0;
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        while (first < len - 2) {
            if (nums[first] > 0) {
                break;
            }
            // first we find the ans, then we distinct the ans.
            if (first > 0 && nums[first] == nums[first - 1]) {
                first++;
                continue;
            }
            int l = first + 1;
            int r = len - 1;
            while (l < r) {
                int sum = nums[first] + nums[l] + nums[r];
                if (sum == 0) {
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[l++]);
                    list.add(nums[r--]);
                    ans.add(list);
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
            first++;
        }
        return ans;
    }


}
