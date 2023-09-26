package com.gzy.algo.month202309;

import java.util.*;

public class September25MergeIntervals {


    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;

        Map<Integer, Integer> map = new HashMap<>();
        int[] starts = new int[len];
        Arrays.fill(starts, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++){
            if (map.containsKey(intervals[i][0])){
                map.put(intervals[i][0], Math.max(intervals[i][1], map.get(intervals[i][0])));
            }else{
                map.put(intervals[i][0], intervals[i][1]);
                starts[i] = intervals[i][0];
            }

        }
        Arrays.sort(starts);
        int start = -1;
        int size = map.size();
        for (int i = 0; i < size; i++){

            if (start == -1){
                start = starts[i];
            }else {
                if (starts[i] <= map.get(start)){
                    Integer newEnd = Math.max(map.get(starts[i]), map.get(start));
                    map.remove(starts[i]);
                    map.put(start, newEnd);

                }else {
                    start = starts[i];
                }
            }
        }

        int[][] res = new int[map.size()][2];
        int index = 0;
        for (Integer key : map.keySet()){

            res[index][0] = key;
            res[index++][1] = map.get(key);

        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ints = {{1,4},{0,2},{3,5}};
        int[][] res = merge(ints);
        System.out.println(res);
    }
}
