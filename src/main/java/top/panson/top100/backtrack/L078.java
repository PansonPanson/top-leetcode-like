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
        // 结果集合：存储所有子集
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            // 记录当前路径（已选择的元素）
            List<Integer> currentSubset = new ArrayList<>();

            // 启动回溯过程，起始索引为0
            backtrack(nums, 0, currentSubset);

            return result;
        }

        /**
         * 回溯核心方法
         * @param nums         : 原始输入数组
         * @param startIndex   : 当前选择的起始索引
         * @param currentSubset: 当前已选择的元素集合
         */
        private void backtrack(int[] nums, int startIndex, List<Integer> currentSubset) {
            // 每次递归都记录当前状态（关键点！）
            result.add(new ArrayList<>(currentSubset));

            // 遍历所有可选择的元素：从startIndex开始避免重复
            for (int i = startIndex; i < nums.length; i++) {
                /************ 做选择阶段 ************/
                // 1. 将当前元素加入子集
                currentSubset.add(nums[i]);

                /************ 递归阶段 ************/
                // 递归处理后续元素（重要：从i+1开始避免重复）
                backtrack(nums, i + 1, currentSubset);

                /************ 撤销选择阶段 ************/
                // 移出最后加入的元素（回溯）
                currentSubset.remove(currentSubset.size() - 1);
            }
            // 注意：这里没有显式终止条件，因为循环结束自然返回
        }
    }
}
