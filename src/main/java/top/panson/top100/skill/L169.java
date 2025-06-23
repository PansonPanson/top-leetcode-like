package top.panson.top100.skill;

/**
 * @author Panson
 * @create 2025-06-16
 */
public class L169 {
    class Solution {
        public int majorityElement(int[] nums) {
            // 投票法，先假定当前数为目标数，如果后续遍历不一致，则抵消，如果一致，则票数+1
            int vote = 0;
            int res = nums[0];
            for(int num : nums) {
                if(vote == 0) {
                    vote = 1;
                    res = num;
                } else {
                    if(num == res) {
                        vote++;
                    } else {
                        vote--;
                    }
                }
            }
            return res;
        }
    }
}
