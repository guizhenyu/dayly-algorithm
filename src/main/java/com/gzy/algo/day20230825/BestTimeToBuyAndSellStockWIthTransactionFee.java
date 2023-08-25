package com.gzy.algo.day20230825;

public class BestTimeToBuyAndSellStockWIthTransactionFee {
    /**
     * You are given an array prices where prices[i] is the price of a given stock on the i-th day, and an integer fee
     * representing a transaction fee.
     * Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for
     * each transaction.
     *
     * Note:
     * You may not engage in multiple transaction simultaneously(i.e., you must sell the stock before you buy again).
     * The transaction fee is only charged once for each stock purchase and sale.
     *
     * Constraints:
     * 1 <= prices.length <= 5 * 10 ^ 4
     * 1 <= prices[1] < 5 * 10 ^ 4
     * 0 <= fee <5 * 10 ^ 4
     * @param prices
     * @param fee
     * @return
     */

    public int maxProfit(int[] prices, int fee){
        if (prices == null || prices.length < 2){
            return 0;
        }

        return violentRecursive(prices, fee, 0, -1);
    }

    public int violentRecursive(int[] prices, int fee, int index, int buyIndex){

        if(index == prices.length){
            return 0;
        }

        if (buyIndex >= 0){

            int p1 = prices[index] - prices[buyIndex] - fee + violentRecursive(prices, fee, index + 1, -1);
            int p2 = violentRecursive(prices, fee, index + 1, buyIndex);

            return Math.max(p1, p2);
        }else {
            int p3 = violentRecursive(prices, fee, index + 1, buyIndex);
            int p4 = violentRecursive(prices, fee, index + 1, index);
            return Math.max(p3, p4);
        }
    }

    public int dp(int[] prices, int fee){
        if (prices == null || prices.length < 2){
            return 0;
        }

        int bestBuy = -prices[0] - fee;
        int bestSell = 0;
        for (int i = 1; i < prices.length; i++){
            int curBuy = bestSell - prices[i] - fee;
            int curSell = bestBuy + prices[i];
            bestSell = Math.max(curSell, bestSell);
            bestBuy = Math.max(curBuy, bestBuy);
        }


        return bestSell;
    }

}
