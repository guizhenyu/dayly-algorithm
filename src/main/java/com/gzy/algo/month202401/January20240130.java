package com.gzy.algo.month202401;

public class January20240130 {

    public int singleNumber(int[] nums) {
        int seed = 0;

        for (int num : nums) {
            seed ^= num;
        }

        return seed;
    }
}
