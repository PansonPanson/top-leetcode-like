package top.panson.top100.tree;

import top.panson.top100.commondata.TreeNode;

/**
 * @author Panson
 * @create 2025-07-06
 */
public class L101 {
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
        public boolean isSymmetric(TreeNode root) {
            if(root == null) {
                return true;
            }
            return traverse(root.left, root.right);
        }

        public boolean traverse(TreeNode left, TreeNode right) {
            if(left == null && right == null) {
                return true;
            }
            if(left == null || right == null) {
                return false;
            }

            if(left.val != right.val) {
                return false;
            }

            return traverse(left.left, right.right)  && traverse(left.right, right.left);
        }
    }
}
