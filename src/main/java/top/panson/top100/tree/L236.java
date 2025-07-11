package top.panson.top100.tree;

import top.panson.top100.commondata.TreeNode;

/**
 * @author Panson
 * @create 2025-07-11
 */
public class L236 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return traverse(root, p, q);
        }


        /**
         * 先序遍历，先判断 root，再递归判断左右子树
         */
        TreeNode traverse(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null) {
                return null;
            }
            if(root == p || root == q) {
                return root;
            }

            TreeNode targetLeft = traverse(root.left, p, q);
            TreeNode targetRight = traverse(root.right, p, q);

            if(targetLeft != null && targetRight != null) {
                return root;
            }
            return targetLeft != null ? targetLeft : targetRight;
        }

    }
}
