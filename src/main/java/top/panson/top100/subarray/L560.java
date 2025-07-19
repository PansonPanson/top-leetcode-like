package top.panson.top100.subarray;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2025-07-19
 */
public class L560 {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int n = nums.length;
            int sum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int res = 0;
            for(int i = 0; i < n; i++) {
                sum += nums[i];
                if(map.containsKey(sum - k)) {
                    res += map.get(sum - k);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return res;
        }
    }
}
