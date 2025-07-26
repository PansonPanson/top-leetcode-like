package top.panson.top100.greedy;

/**
 * @author Panson
 * @create 2025-07-01
 */
public class L045 {
    class Solution {
        public int jump(int[] nums) {
            // 跳第一个，设置最远边界1，在这个边界里遍历，记录所能达到的最远距离2，更新2，到达最远边界 step+1
            int step = 0;
            // 当前右边界
            int windowEnd = 0;
            // 维护下一次右边界
            int maxReach = 0;
            int n = nums.length;
            for(int i = 0; i < n; i++) {
                if(i + nums[i] > maxReach) {
                    maxReach = i + nums[i];
                }

                if(i == windowEnd && i < n - 1) {
                    step++;
                    windowEnd = maxReach;
                }
            }
            return step;
        }
    }
}
