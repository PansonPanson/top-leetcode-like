package top.panson.top100.tree;

import java.util.ArrayList;
import java.util.List;
import  top.panson.top100.commondata.*;

/**
 * @author Panson
 * @create 2025-07-06
 */
public class L94 {
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
        List<Integer> res = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {

            traverse(root);
            return res;
        }

        public void traverse(TreeNode root) {
            if(root == null) {
                return;
            }
            traverse(root.left);
            res.add(root.val);
            traverse(root.right);
        }
    }
}
