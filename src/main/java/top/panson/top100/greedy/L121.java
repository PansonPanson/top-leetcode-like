package top.panson.top100.greedy;

/**
 * @author Panson
 * @create 2025-06-30
 */
public class L121 {
    class Solution {
        public int maxProfit(int[] prices) {
            int curMinPrice = Integer.MAX_VALUE;
            int maxProfit = 0;
            for(int price : prices) {
                if(price < curMinPrice) {
                    curMinPrice = price;
                }
                maxProfit = Math.max(price - curMinPrice, maxProfit);
            }
            return maxProfit;
        }
    }
}
