package com.gzy.algo.month202310;

import java.util.HashSet;
import java.util.Set;

class October17LongestConsecutiveSequence {
    /**
     * Given an unsorted array of integers nums, return the length of the longest consecutive
     * elements sequence. You must write an algorithm that runs in O(n) time.
     *
     */

    public int longestConsecutive(int[] nums){
        Set<Integer> sets = new HashSet<>();
        int ans = 0;
        for (int num : nums){
            sets.add(num);
        }

        for (int num : sets){
            if (!sets.contains(num - 1)){
                int currentNum = num;
                int currentAns = 1;

                while (sets.contains(currentNum + 1)){
                    currentNum++;
                    currentAns++;
                }
                ans = Math.max(currentAns, ans);

            }



        }


        return ans;
    }



}
