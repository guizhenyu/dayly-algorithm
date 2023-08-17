package com.gzy.algo.day20230815;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TallestBillboard {


    public static int tallestBillboard(int[] rods) {
        // the dp map's key represents the height diff ,
        // the dp map's value represents the lowest height of current
        HashMap<Integer, Integer> dp = new HashMap<>(), cur;
        // init value
        dp.put(0, 0);

        for (int num : rods) {
            if (num != 0) {
                cur = new HashMap<>(dp);
                for (int d : cur.keySet()) {
                    int diffMore = cur.get(d);

                    //first: put the num into the higher
                    dp.put(d + num, Math.max(dp.getOrDefault(d + num, 0), diffMore));

                    // second: put the num into the lower
                    int diffXD = dp.getOrDefault(Math.abs(num - d), 0);
                    if (d >= num) {
                        dp.put(d - num, Math.max(diffXD, diffMore + num));
                    } else {
                        dp.put(num -d, Math.max(diffXD, diffMore + d));
                    }

                }
            }
        }


        return dp.get(0);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 6};
        System.out.println(tallestBillboard(nums));
    }


}
