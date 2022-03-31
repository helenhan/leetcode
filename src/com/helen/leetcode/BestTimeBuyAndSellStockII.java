package com.helen.leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/discuss/39402/Is-this-question-a-joke
 * Created by Helen on 3/5/2018.
 */
public class BestTimeBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int total = 0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i+1]>prices[i]){
                total += prices[i+1]-prices[i];
            }
        }
        return total;
    }
}
