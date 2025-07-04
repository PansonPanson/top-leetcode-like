package top.panson.top100.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panson
 * @create 2025-07-04
 */
public class L039 {

    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            backtrack(candidates, res, target, path, 0, 0);
            return res;
        }

        public void backtrack(int[] candidates, List<List<Integer>> res, int target, List<Integer> path, int sum, int start) {


            if(sum == target) {
                res.add(new ArrayList<>(path));
                return;
            }

            if(sum > target) {
                return;
            }

            for(int i = start; i < candidates.length; i++) {

                sum += candidates[i];
                path.add(candidates[i]);
                backtrack(candidates, res, target, path, sum, i);
                sum -= candidates[i];
                path.remove(path.size() - 1);
            }
        }
    }
}
