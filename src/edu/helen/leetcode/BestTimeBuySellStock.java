package edu.helen.leetcode;

/**
 * Created by Helen on 9/25/2017.
 */
public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int min = prices[0];
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<min){
                min = prices[i];
            }else {
                profit = Math.max(prices[i]-min, profit);
            }
        }
        return profit;
    }
}
