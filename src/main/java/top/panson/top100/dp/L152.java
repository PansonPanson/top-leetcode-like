package top.panson.top100.dp;

/**
 * @author Panson
 * @create 2025-06-29
 */
public class L152 {
    class Solution {
        public int maxProduct(int[] nums) {
            // dpMax[i]: 以 i 结尾的最大乘积
            // dpMin[i]: 以 i 结尾的最小乘积
            int n = nums.length;
            int[] dpMax = new int[n];
            int[] dpMin = new int[n];
            dpMax[0] = nums[0];
            dpMin[0] = nums[0];
            int max = nums[0];
            for(int i = 1; i < n; i++) {
                int num1 = dpMax[i - 1] * nums[i];
                int num2 = dpMin[i - 1] * nums[i];
                dpMax[i] = Math.max(nums[i], Math.max(num1, num2));
                dpMin[i] = Math.min(nums[i], Math.min(num1, num2));
                max = Math.max(max, dpMax[i]);
            }
            return max;

        }
    }
}
