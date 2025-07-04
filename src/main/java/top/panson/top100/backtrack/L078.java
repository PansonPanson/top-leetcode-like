package top.panson.top100.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panson
 * @create 2025-07-04
 */
public class L078 {

    /**
     * deepseek 递归树
     * 第1层（start=0）
     * │
     * ├─ 初始路径: [] → 加入结果
     * ├─ 选择1 → 进入递归
     * │    │
     * │    ├─ 第2层（start=1）
     * │    │   ├─ 当前路径: [1] → 加入结果
     * │    │   ├─ 选择2 → 进入递归
     * │    │   │   │
     * │    │   │   ├─ 第3层（start=2）
     * │    │   │   │   ├─ 当前路径: [1,2] → 加入结果
     * │    │   │   │   ├─ 选择3 → [1,2,3] → 加入结果（最深层）
     * │    │   │   │   └─ 回溯移除3 → 回退到[1,2]
     * │    │   │   │
     * │    │   │   └─ 回溯移除2 → 回退到[1]
     * │    │   │
     * │    │   └─ 选择3（跳过2）→ [1,3] → 加入结果 → 回溯
     * │    │
     * │    └─ 回溯移除1 → 回退到[]
     * │
     * └─ 选择2 → 进入递归（start=1）
     *      │
     *      ├─ 当前路径: [2] → 加入结果
     *      ├─ 选择3 → [2,3] → 加入结果 → 回溯
     *      └─ 回溯移除2 → 回退到[]
     */
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            traverse(nums, res, path, 0);
            return res;
        }

        public void traverse(int[] nums, List<List<Integer>> res, List<Integer> path, int start) {


            res.add(new ArrayList<>(path));

            for(int i = start; i < nums.length; i++) {

                path.add(nums[i]);
                traverse(nums, res, path, i + 1);
                path.remove(path.size() - 1);
            }

        }
    }
}
