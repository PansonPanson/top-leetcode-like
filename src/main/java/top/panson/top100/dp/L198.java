package top.panson.top100.dp;

/**
 * @author Panson
 * @create 2025-06-26
 */
public class L198 {
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if(n == 0) {
                return 0;
            }
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = nums[0];

            for(int i = 1; i < n; i++) {
                //
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
                dp[i][1] = dp[i - 1][0] + nums[i];
            }
            return Math.max(dp[n - 1][0], dp[n - 1][1]);
        }
    }
}
