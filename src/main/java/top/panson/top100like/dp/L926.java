package top.panson.top100like.dp;

/**
 * @author Panson
 * @create 2025-06-23
 */
public class L926 {

    class Solution {
        public int minFlipsMonoIncr(String s) {
            //  dp[i]: 前 i 个字符最小翻转次数
            int n = s.length();
            int[] dp = new int[n + 1];
            int oneCount = 0;
            for(int i = 1; i <= n; i++) {
                if(s.charAt(i - 1) == '1') {
                    oneCount++;
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = Math.min(dp[i - 1] + 1, oneCount);
                }
            }
            return dp[n];

        }
    }
}
