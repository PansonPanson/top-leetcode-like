package top.panson.top100.dp;

import java.util.Arrays;

/**
 * @author Panson
 * @create 2025-06-29
 */
public class L300 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            // dp[i]:以 num[i - 1]结尾的最长递增子序列长度
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int maxLen = 1;
            for(int i = 0; i < n; i++) {
                // 每一次内层循环结束，dp[i]就确定下来了
                for(int j = 0; j < i; j++) {
                    if(nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
            return maxLen;
        }
    }
}
