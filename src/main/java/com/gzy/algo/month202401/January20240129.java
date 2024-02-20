package com.gzy.algo.month202401;

public class January20240129 {

    public int maxProfit(int[] prices){
        if (prices == null || prices.length < 2){
            return 0;
        }

        int ans = 0;
        int lowestPrice = prices[0];

        for (int i = 1; i < prices.length; i++){
            ans = Math.max(ans, prices[i] - lowestPrice);
            lowestPrice = Math.min(lowestPrice, prices[i]);
        }

        return ans;
    }
}
