package top.panson.top100.tree;

import top.panson.top100.commondata.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2025-07-09
 */
public class L437 {

    class Solution {

        int count = 0;
        Map<Long, Integer> prefixMap = new HashMap<>();
        public int pathSum(TreeNode root, int targetSum) {
            // 为了让**「从根节点直接到某个节点的路径正好等于 targetSum」**这类路径也能被统计进去。
            prefixMap.put(0L, 1);
            traverse(root, targetSum, 0L);
            return count;
        }

        public void traverse(TreeNode root, int targetSum, long curSum) {

            if(root == null) {
                return;
            }
            curSum += root.val;

            // 查看之前是否存在一个前缀和，使得从那个点到当前点的路径和等于 targetSum
            count += prefixMap.getOrDefault(curSum - targetSum, 0);

            prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) + 1);

            traverse(root.left, targetSum, curSum);
            traverse(root.right, targetSum, curSum);

            prefixMap.put(curSum, prefixMap.get(curSum) - 1);
        }
    }
}
