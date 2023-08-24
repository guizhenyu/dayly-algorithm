package com.gzy.algo.day20230824;

public class BestTImeToBuyAndSellStockWithCoolDown {
    // leecode 309
    /**
     *
     *
     * You are given an array prices where prices[i] is the price of a given stock on the i-th day.
     * FInd the maximum profit you can achieve. You may complete as many transactions as you like(i.e., buy one and sell one share of the stock multiple times)
     * with the following restrictions:
     * After you sell your stock, you cannot buy stock on the next day(i.e., cool down one day).
     * Note:
     * you may not engage(参与) in multiple transactions simultaneously(同时)(i.e., you must sell the stock before you buy again)
     * 你不能同时参与多个交易
     *
     * Constraints:
     * 1 <= prices.length <= 5000
     * 0 <= prices[i] <= 1000
     *
     * @param prices
     * @return
     */


    public int maxProfit(int[] prices){

        return violentRecursive(prices, false, 0, 0);
    }

    /**
     * violent recursive implementation
     * @param prices
     * @param hasBuy  means does buy happen before
     * @param index  index of day
     * @param buyIndex
     * @return
     */
    private int violentRecursive(int[] prices, boolean hasBuy, int index, int buyIndex) {
        if (index >= prices.length){
            return 0;
        }
        if (hasBuy){
            // sell at index day
            int p1 = (prices[index] - prices[buyIndex]) + violentRecursive(prices, false, index + 2, buyIndex);
            // do nothing
            int p2 = violentRecursive(prices, true, index + 1, buyIndex);
            return Math.max(p1, p2);
        }else {
            // buy now
            int p3 = violentRecursive(prices, true, index + 1, index);
            // do nothing

            int p4 = violentRecursive(prices, false, index + 1, index);

            return Math.max(p3, p4);
        }

    }
}
