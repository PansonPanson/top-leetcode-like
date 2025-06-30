package top.panson.top100.greedy;

/**
 * @author Panson
 * @create 2025-06-30
 */
public class L055 {
    class Solution {
        public boolean canJump(int[] nums) {
            int farthest = 0;
            for(int i = 0; i < nums.length; i++) {
                if(i > farthest) {
                    return false;
                }
                farthest = Math.max(farthest, i + nums[i]);
            }
            return true;
        }
    }
}
