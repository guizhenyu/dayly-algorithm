package com.gzy.algo.month202311;

import java.util.Arrays;
import java.util.stream.Stream;

public class November12HouseRobberII {


    public int rob(int[] nums) {
        int len = nums.length;

        int[] newNums = new int[len + 1];
        for (int i = 0; i < len; i++){
            newNums[i] = nums[i];
        }
        newNums[len]  = Integer.MIN_VALUE;
        int p1 = process(newNums, 0);
        newNums[len] = 0;
        int p2 = process(newNums, 1);
        return  Math.max(p1, p2);


    }
    public int dp(int[] nums){
        /**
         * 打劫的问题环形的，选择了第一家，最后一个家就绝对不能碰，
         */
        int len = nums.length, ans = Integer.MIN_VALUE;

        if (len <= 2){
            for (int num : nums){
                ans = Math.max(ans, num);
            }
            return ans;
        }

        int[] dp1 = new int[len];
        // 第一个必选，那么最后一个就不能考虑
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < len - 1; i++){
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
        }

        int[] dp2 = new int[len];
        dp2[1] = nums[1];

        for (int i = 2; i < len; i++){
            dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
        }

        return Math.max(dp1[len - 2], dp2[len - 1]);
    }

    private int process(int[] newNums, int index) {
        if (index >= newNums.length - 1 || newNums[index + 1] == Integer.MIN_VALUE){
            return 0;
        }
        int p1 = process(newNums, index + 2);
        p1 = p1 == Integer.MIN_VALUE? p1: p1 + newNums[index];
        int p2 = process(newNums, index + 1);
        return Math.max(p1, p2);

    }

    public int process(int[] nums, int index, boolean[] chose){
        if (index == nums.length){
            return 0;
        }
        if (chose[index + 1]){
            return Integer.MIN_VALUE;
        }
        chose[index + nums.length] = true;
        int p1 = process(nums, index + 1, chose);
        p1 = p1 == Integer.MIN_VALUE? p1 : p1 + nums[index];

        chose[index + nums.length] = false;
        p1 = Math.max(p1, process(nums, index + 1, chose));

        return Math.max(0, p1);
    }


    public static void main(String[] args) {
        Stream.of(1,1,1,1).parallel().map(x -> x + 1).reduce((x, y) -> x + y).get();
    }
}
