package top.panson.top100.skill;

/**
 * @author Panson
 * @create 2025-06-16
 */
public class L136 {
    /**
     * 使用异或
     */
    class Solution {
        public int singleNumber(int[] nums) {
            int res = 0;
            for(int num : nums) {
                res ^= num;
            }
            return res;
        }
    }
}
