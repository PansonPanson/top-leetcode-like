package top.panson.top100.dp;

/**
 * @author Panson
 * @create 2025-06-26
 */
public class L072 {
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) dp[i][0] = i; // 全部删除
            for (int j = 0; j <= n; j++) dp[0][j] = j; // 全部插入
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(word1.charAt(i) == word2.charAt(j)) {
                        dp[i + 1][j + 1] = dp[i][j];
                    } else {
                        dp[i + 1][j + 1] = Math.min(
                                Math.min(dp[i][j], dp[i][j + 1]), dp[i + 1][j]
                        ) + 1;
                    }
                }
            }
            return dp[m][n];

        }
    }
}
