package com.gzy.algo.day20230822;

public class BestTimeToBuyAndSellStockIII {


    /**
     * You are given an array prices where prices[i] is the price of a given stock on the i-th day.
     * Find the maximum profit you can achieve. You may complete at most two transactions.
     *
     * Note:
     * You may not engage int multiple transactions simultaneously (i.e, you must sell the stock before you buy again).
     *
     * Constraints:
     * 1 <= prices.length <= 10^5
     * 0 <= prices[i] <= 10^5
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){
        int len = prices.length;

        int[][][] dp = new int[len - 1][2][3];
        dp[0][1][1] = -prices[0];

        for (int i = 1; i <= 2; i++){
            for (int j = 1; j < len; j++){
                dp[j][0][i] = Math.max(dp[j - 1][0][i], dp[j - 1][1][i] + prices[j]);
                dp[j][1][i] = Math.max(dp[j - 1][0][i] - prices[j], dp[j - 1][1][i]);
            }
        }

        return Math.max(Math.max(dp[len - 1][0][0], dp[len - 1][0][1]), dp[len - 1][0][2]);
    }

//    public int natureWisdom(int[] prices, int index, int limit, int profit){
//
//
//    }
}
