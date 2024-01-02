package com.gzy.algo.month202312;

import java.util.ArrayList;
import java.util.List;

public class December31CombinationSum {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        process(candidates, 0, target, new ArrayList<>(), result);


        return result;
    }

    private void process(int[] candidates, int i, int left, List<Integer> list, List<List<Integer>> result) {

        if (i >= candidates.length){
            return;
        }

        if (left == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        process(candidates, i + 1, left, list, result);

        if (left >= candidates[i]){
            list.add(candidates[i]);
            process(candidates, i, left - candidates[i], list, result);
            list.remove(list.size() - 1);
        }

    }


}
