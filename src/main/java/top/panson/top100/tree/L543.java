package top.panson.top100.tree;

import top.panson.top100.commondata.TreeNode;

/**
 * @author Panson
 * @create 2025-07-06
 */
public class L543 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {

        int max = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            length(root);
            return max;
        }

        /**
         * 以 root 为根节点的树高
         */
        public int length(TreeNode root) {
            if(root == null) {
                return 0;
            }
            int leftLength = length(root.left);
            int rightLength = length(root.right);
            max = Math.max(max, leftLength + rightLength);
            return Math.max(leftLength, rightLength) + 1;
        }
    }
}
