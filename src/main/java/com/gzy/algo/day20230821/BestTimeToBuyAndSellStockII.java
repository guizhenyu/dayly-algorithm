package com.gzy.algo.day20230821;

public class BestTimeToBuyAndSellStockII {

    /**
     * You are given an integer array prices where prices[i] is the price of a given stock on the i-th day.
     * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at
     * any time.However, you can buy it then immediately sell it to the same day.
     *
     * Find and return the maximum profit you can achieve.
     *
     * Constraints:
     * 1 <= prices.length <= 3 * 10^4
     * 0 <= prices[i] <= 10^4
     *
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){
        //
        return natureWisdom(prices, 0, -1, 0);
    }


    public int natureWisdom(int[] prices, int index, int buyPrice, int profits){
        if (index == prices.length - 1){
            if (buyPrice >= 0){
                profits += prices[index] - buyPrice;
            }
            return profits;
        }
        int ans = 0;
        if (buyPrice >= 0){
            int p1 = natureWisdom(prices,  index + 1, -1, profits + (prices[index] - buyPrice));
            int p2 = natureWisdom(prices, index + 1, buyPrice, profits);
            ans = Math.max(p1, p2);

        }else {
            int p1 = natureWisdom(prices,  index + 1, buyPrice, profits );
            int p2 = natureWisdom(prices, index + 1, prices[index], profits);
            ans = Math.max(p1, p2);
        }

        return ans;
    }

    public int dp(int[] prices){
        int len = prices.length;
        int[][] dp  = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
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
