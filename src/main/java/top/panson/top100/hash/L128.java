package top.panson.top100.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Panson
 * @create 2025-07-19
 */
public class L128 {
    class Solution {
        public int longestConsecutive(int[] nums) {

            Set<Integer> set = new HashSet<>();
            for(int num : nums) {
                set.add(num);
            }
            int maxLength = 0;
            for(int num : set) {
                // 只有在当前元素是递增序列开头时才往下走
                if(set.contains(num - 1)) {
                    continue;
                }
                int cur = num;
                int length = 1;
                while(set.contains(cur + 1)) {
                    length++;
                    cur++;
                }
                maxLength = Math.max(maxLength, length);
            }
            return maxLength;
        }
    }
}
