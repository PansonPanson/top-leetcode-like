package top.panson.top100like.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Panson
 * @create 2025-06-24
 */
public class L491 {

    class Solution {
        public List<List<Integer>> findSubsequences(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();

            traverse(nums, res, new ArrayList<>(), 0);
            return res;
        }

        public void traverse(int[] nums, List<List<Integer>> res, List<Integer> path, int start) {
            if(path.size() >= 2) {
                res.add(new ArrayList<>(path));
            }
            Set<Integer> used = new HashSet<>();

            for(int i = start; i < nums.length; i++) {
                if(path.size() > 0 && nums[i] < path.get(path.size() - 1)) {
                    continue;
                }
                if(used.contains(nums[i])) {
                    continue;
                }
                path.add(nums[i]);
                used.add(nums[i]);
                traverse(nums, res, path, i + 1);
                path.removeLast();
            }

        }
    }
}
