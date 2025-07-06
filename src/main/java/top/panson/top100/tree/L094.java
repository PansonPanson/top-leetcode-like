package top.panson.top100.tree;

import top.panson.top100.commondata.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Panson
 * @create 2025-07-06
 */
public class L094 {

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
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode cur = root;
            while(cur != null || !stack.isEmpty()) {
                while(cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                TreeNode pop = stack.pop();
                res.add(pop.val);
                cur = pop.right;
            }
        }
    }
}
