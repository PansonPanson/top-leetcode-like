package top.panson.top100.dp;

/**
 * @author Panson
 * @create 2025-06-27
 */
public class L416 {

    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for(int num : nums) {
                sum += num;
            }
            if(sum % 2 != 0) {
                return false;
            }
            int target = sum / 2;
            int n = nums.length;
            boolean[][] dp = new boolean[n + 1][target + 1];
            for(int i = 0; i < n; i++) {
                dp[i][0] = true;
            }

            // dp[i][j] : 前 i 个数是否存在刚好组成和为 j 的子集
            // 遍历物品
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= target; j++) {
                    if(j >= nums[i - 1]) {
                        // 0~i-1 个数已经存在，或者0~i-1 存在 j - nums[i - 1
                        dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[n][target];

        }
    }
}
