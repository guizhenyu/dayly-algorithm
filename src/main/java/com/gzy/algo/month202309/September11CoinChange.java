package com.gzy.algo.month202309;

import java.lang.reflect.Array;
import java.util.Arrays;

public class September11CoinChange {


    /**
     * You are given an integer array coins representing coins of different denominations and an integer amount
     * representing a total amount of money.
     * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be make
     * up by any combination of coins, return -1.
     * You may resume that you have an infinite number of each kind of coin.
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int ans = process(coins, amount, 0);
        return ans == Integer.MAX_VALUE? -1 : ans;
    }

    public int coinChangeDp(int[] coins, int amount) {
        int len = coins.length;
        int maxVal = amount + 1;
        int[][] dp = new int[len + 1][amount + 1];

        for (int i = 0; i <= len; i++){
            for (int j = 0; j <= amount; j++){
                if (j == 0){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = maxVal;
                }
            }
        }


        for (int i = len - 1; i >= 0; i--){
            for (int j = 1; j <= amount; j++){
                int ans = dp[i + 1][j];
                if (j >= coins[i]){
                    int p1 = dp[i][j - coins[i]];
                    int p2 = dp[i + 1][j - coins[i]];

                    p1 = Math.min(p1, p2);

                    if (p1 != maxVal){
                        ans = Math.min(ans, p1 + 1);
                    }
                }
                dp[i][j] = ans;
            }
        }


        return dp[0][amount] == maxVal? -1: dp[0][amount];

    }

    public int coinChangeDpOptimize(int[] coins, int amount) {
        int len = coins.length;
        int maxVal = amount + 1;
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, maxVal);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++){
            for (int j = len - 1; j >= 0; j--){
                if (i >= coins[j]){
                    dp[i] = Math.min(dp[i],
                            dp[i - coins[j]] == maxVal? maxVal : dp[i - coins[j]] + 1);
                }


            }
        }

        return dp[amount] == maxVal? -1 : dp[amount];
    }

    private int process(int[] coins, int amount, int index) {
        if (amount == 0){
            return 0;
        }

        if (coins.length == index || amount < 0){
            return Integer.MAX_VALUE;
        }
        // first. skip the index
        int ans = process(coins, amount, index + 1);

        // second. use index coin
        int p2 = process(coins, amount - coins[index], index);
        // third.  use the index coin and unchange index
        int p3 = process(coins, amount - coins[index], index + 1);
        p2 = Math.min(p2, p3);
        if (p2 != Integer.MAX_VALUE){
            p2++;
            ans = Math.min(ans, p2);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        September11CoinChange coinChange = new September11CoinChange();

        int ans = coinChange.coinChange(coins, 11);
        System.out.println(ans);
    }
}
