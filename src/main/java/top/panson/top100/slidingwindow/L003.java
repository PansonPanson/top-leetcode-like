package top.panson.top100.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2025-06-24
 */
public class L003 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            // 双指针
            Map<Character, Integer> map = new HashMap<>();
            int left = 0;
            int right = 0;
            int maxLength = 0;
            for(int i = 0; i < s.length(); i++) {
                if(!map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), i);
                } else {
                    int preIndex = map.get(s.charAt(i));
                    map.put(s.charAt(i), i);
                    // dvdf
                    left = Math.max(left, preIndex + 1);
                }
                maxLength = Math.max(maxLength, i - left + 1);
            }
            return maxLength;
        }
    }
}
