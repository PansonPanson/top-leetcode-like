package top.panson.top100.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Panson
 * @create 2025-07-01
 */
public class L347 {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
                    (a, b) -> (a.getValue() - b.getValue())
            );
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                queue.offer(entry);
                if(queue.size() > k) {
                    queue.poll();
                }
            }

            int[] res = new int[k];
            int i = 0;
            while(!queue.isEmpty()) {
                res[i++] = queue.poll().getKey();
            }
            return res;

        }
    }
}
