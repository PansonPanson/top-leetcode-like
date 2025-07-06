package top.panson.top100.tree;

import top.panson.top100.commondata.TreeNode;

/**
 * @author Panson
 * @create 2025-07-06
 */
public class L226 {
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
        public TreeNode invertTree(TreeNode root) {
            traverse(root);
            return root;
        }

        public void traverse(TreeNode root) {
            if(root == null) {
                return;
            }
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = tmp;

            traverse(root.left);
            traverse(root.right);
        }
    }
}
