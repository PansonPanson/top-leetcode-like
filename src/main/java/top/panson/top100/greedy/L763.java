package top.panson.top100.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Panson
 * @create 2025-07-01
 */
public class L763 {
    class Solution {
        public List<Integer> partitionLabels(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                map.put(ch, i);
            }

            List<Integer> res = new ArrayList<>();
            int end = 0;
            int start = 0;
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                end = Math.max(end, map.get(ch));
                if(i == end) {
                    res.add(i - start + 1);
                    start = i + 1;
                }
            }
            return res;
        }
    }
}
