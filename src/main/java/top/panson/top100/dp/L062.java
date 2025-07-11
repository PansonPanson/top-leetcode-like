package top.panson.top100.dp;

/**
 * @author Panson
 * @create 2025-06-26
 */
public class L062 {
    class Solution {
        public int uniquePaths(int m, int n) {

            int[][] dp = new int[m][n];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == 0) {
                        dp[i][j] = 1;
                        continue;
                    }
                    if(j == 0) {
                        dp[i][j] = 1;
                        continue;
                    }
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];

        }
    }
}
