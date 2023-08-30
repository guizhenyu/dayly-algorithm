package com.gzy.algo.month202308.day20230823;

public class BestTImeToBuyAndSellStock {

    /**
     * You are given an array prices where prices[i] is the price of a given stock on the i-th day.
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day
     * in the future to sell that stock.
     *
     * Return tne maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     *
     * Constraints:
     * 1 <= prices.length <= 10 ^ 5
     * 0 <= prices[i] <= 10 ^ 4
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){

        // the array prices is null or it's length is less than 2, then return 0
        // because it cannot support buying and sell a stock;
        if (prices == null || prices.length < 2){
            return 0;
        }

        // the variable ans represents the return answer.
        int ans = 0;
        // the variable lowestPrice represents the lowest price of the stock。
        // 'cause buy and sell a stock must be a different day, so initialization of lowestPrice is prices[0]
        int lowestPrice = prices[0];
        // so we iterate the prices array from index 1.
        for(int i = 1; i < prices.length; i++){
            // where sell the sock at i index, then the profit equals prices[i] - lowestPrice
            ans = Math.max(ans, prices[i] - lowestPrice);
            // update lowestPrice
            lowestPrice = Math.min(lowestPrice, prices[i]);
        }


        return ans;
    }
}
