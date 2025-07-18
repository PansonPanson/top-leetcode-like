package top.panson.top100.tree;

import top.panson.top100.commondata.TreeNode;

/**
 * @author Panson
 * @create 2025-07-07
 */
public class L108 {
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return build(nums, 0, nums.length - 1);
        }

        public TreeNode build(int[] nums, int left, int right) {
            if(left > right) {
                return null;
            }

            int mid = left + (right - left) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = build(nums, left, mid - 1);
            root.right = build(nums, mid + 1, right);
            return root;
        }
    }
}
