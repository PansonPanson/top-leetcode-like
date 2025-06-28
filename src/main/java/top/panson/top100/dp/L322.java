package top.panson.top100.dp;

import java.util.Arrays;

/**
 * @author Panson
 * @create 2025-06-28
 */
public class L322 {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            // dp[j] 表示凑成金额 j 所需最少的硬币数量
            int[] dp = new int[amount + 1];
            // 别用最大值，dp[j - coin] + 1 会溢出
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for(int coin : coins) {
                for(int j = coin; j <= amount; j++) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }
}
