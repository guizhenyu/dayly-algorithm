package com.gzy.algo.day20230822;

public class BestTimeToBuyAndSellStockIV {

    /**
     * You are given an integer array prices where prices[i] is the price of a given stock on the i-th day,
     * and integer K.
     *
     * Find the maximum profit you can achieve. You may complete at most k transactions:i.e. you may buy at most
     * k times and sell at most k times.
     *
     * Note:
     * You may not engage in multiple transactions simultaneously(i.e, you must sell the stock before you buy again)
     *
     * Constraints:
     * 1 <= k <= 100
     * 1 <= prices.length <= 1000
     * 0 <= prices[i] <= 1000
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k,  int[] prices){

        if (prices == null || prices.length < 2){
            return 0;
        }

        int len = prices.length;
        // first one transaction includes one buy and one sell.
        // from the simplest situation, the k is unlimited, we can get the ans by greedy algorithm.
        // by greedy algorithm, the largest k equals (len / 2).
        if (k >= len / 2){
            return greedyAlgorithm(prices);
        }
        // create a two-dimensional array to implement dynamic programing algorithm.
        // the first dimension represents that you can trade the stock between index 0 and current index
        // the second dimension represents that you can trade the stock at most index times;
        // so the second dimension index starts with 1, zero makes no sense.
        int[][] dp = new int[len][k + 1];
        // eg: dp[i][j] represents the maximum profit that you can achieve by trading stocks form index 0 to i  in the  prices array,
        // with at most j transactions.
        // dp[i][j] = Math.max (
        //                      dp[i - 1][j],
        //                      dp[i - 1][j - 1] + prices[i] - prices[i],
        //                      dp[i - 2][j - 1] + prices[i] - prices[i - 1]
        //                      dp[i - 3][j - 1] + prices[i] - prices[i - 2]
        //                                         ...
        //                      dp[1][j - 1] + prices[i] - prices[0]
        //                      )
        //           = Math.max (
        //                      dp[i - 1][j],
        //                      Math.max(
        //                              dp[i - 1][j - 1] - prices[i],
        //                              dp[i - 2][j - 1] - prices[i - 1]
        //                              dp[i - 3][j - 1] - prices[i - 2]
        //                                                 ...
        //                              dp[1][j - 1] - prices[0]
        //
        //                        ) + prices[i]
        //
        //                      )
        // after analysis
        // dp[i][j] depends on dp[0...i-1][j-1] and dp[i - 1][j]
        // so we should fill the first-dimension index in ascending order while also fill
        // the second-dimension index values.

        for (int j = 1; j <= k; j++){
            int best = dp[0][j] - prices[0];
            for (int i = 2; i < len; i++){
                dp[i][j] = dp[i - 1][j];

                best = Math.max(best, dp[i - 1][j - 1] - prices[i - 1]);
                dp[i][j] = Math.max(dp[i][j], best + prices[i]);
            }
        }


        return dp[len - 1][k];
    }


    public int greedyAlgorithm(int[] prices){
        // because the time of buy or sell is unlimited,
        // and only the selling price is higher than the buying price that can create profit.
        // so we just calculate and plus all the possibilities that the price[i] is larger than price[i - 1]

        // the variable ans represents the return answer.
        int ans = 0;
        for (int i = 1; i< prices.length; i++){
            if (prices[i] > prices[i - 1]){
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }
}
