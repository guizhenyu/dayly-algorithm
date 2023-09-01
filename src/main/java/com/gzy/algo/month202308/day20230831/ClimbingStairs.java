package com.gzy.algo.month202308.day20230831;

public class ClimbingStairs {


    /**
     * You are climbing a staircase, it takes n steps to reach the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways you climb to the top?
     *
     */

    public int climbStairs(int n){

        int[] dp = new int[n + 1];

        dp[1] = 1;

        dp[0] = 1;
        for (int i = 2; i <= n; i++){

            dp[i] = dp[i - 1] + dp[i - 2];

        }


        return dp[n];
    }

    public int climbStairs1(int n){

        int pre1 = 1;
        int pre0 = 1;
        int ans = 1;
        for (int i = 2; i <= n; i++){
            // int temp = ans;
            ans = pre0 + pre1;
            pre0 = pre1;
            pre1 = ans;
        }


        return ans;
    }



    public int process(int n, int stair, int ans){
        if (stair == n){
            ans += 1;
            return ans;
        }

        ans += process(n, stair + 1, ans);

        if (stair + 2 <= n){
            ans += process(n, stair + 2, ans);
        }

        return ans;
    }
}
