package top.panson.top100.dp;

import java.util.Arrays;

/**
 * @author Panson
 * @create 2025-06-28
 */
public class L279 {
    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, n + 1);
            dp[0] = 0;
            for(int i = 1; i * i <= n; i++) {
                int sqr = i * i;
                for(int j = sqr; j <= n; j++) {
                    // 凑成 j 所需的最少数量
                    dp[j] = Math.min(dp[j], dp[j - sqr] + 1);
                }
            }
            return dp[n];
        }
    }
}
