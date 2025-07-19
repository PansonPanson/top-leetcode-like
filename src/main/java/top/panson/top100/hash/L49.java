package top.panson.top100.hash;

import java.util.*;

/**
 * @author Panson
 * @create 2025-07-19
 */
public class L49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for(String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                if(map.containsKey(key)) {
                    map.get(key).add(str);
                } else {
                    List<String> arr = new ArrayList<>();
                    arr.add(str);
                    map.put(key, arr);
                }
            }
            return new ArrayList<>(map.values());
        }
    }
}
