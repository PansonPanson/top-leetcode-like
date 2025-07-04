package top.panson.top100.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panson
 * @create 2025-07-04
 */
public class L046 {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            traverse(nums, new ArrayList<>());
            return res;
        }

        void traverse(int[] nums, List<Integer> path) {
            if(path.size() == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
            for(int num : nums) {
                if(path.contains(num)) {
                    continue;
                }
                path.add(num);
                traverse(nums, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
