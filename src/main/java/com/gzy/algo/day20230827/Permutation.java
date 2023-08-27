package com.gzy.algo.day20230827;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutation {

    /**
     * given an array nums of distinct integer, return all the possible permutations.
     * you can return the answer in any order.
     *
     */

    public List<List<Integer>> permute(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            map.put(i, nums[i]);
        }
        List<List<Integer>> ans = new ArrayList();

        for (int i = 0; i < nums.length; i++){
            List<Integer> p = new ArrayList<>();
            p.add(nums[i]);
            map.remove(i);
            process(map, ans, p);
            map.put(i, nums[i]);

        }
        return ans;

    }

    public void process(Map<Integer, Integer> map, List<List<Integer>> ans, List<Integer> p){
        if (map.isEmpty()){
            ans.add(p);
        }
        Map<Integer, Integer> cur = new HashMap<>(map);
        for (Integer index : map.keySet()){
            List<Integer> curList = new ArrayList<>(p);
            Integer curVal = map.get(index);
            curList.add(curVal);
            cur.remove(index);
            process(cur, ans, curList);
            cur.put(index, curVal);
        }
    }
}
