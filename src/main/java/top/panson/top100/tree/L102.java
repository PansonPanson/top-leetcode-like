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
public class L102 {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            if(root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> res = new ArrayList<>();
            Deque<TreeNode> queue = new ArrayDeque<>();

            queue.offer(root);
            while(!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> cur = new ArrayList<>();
                for(int i = 0; i < size; i++) {

                    TreeNode poll = queue.poll();
                    cur.add(poll.val);
                    if(poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if(poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
                res.add(cur);
            }
            return res;

        }
    }
}
