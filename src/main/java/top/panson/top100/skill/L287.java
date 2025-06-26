package top.panson.top100.skill;

/**
 * @author Panson
 * @create 2025-06-26
 */
public class L287 {
    class Solution {
        public int findDuplicate(int[] nums) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while(slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            slow = 0;
            while(slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
    }
}
