package top.panson.top100.tree;

import top.panson.top100.commondata.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Panson
 * @create 2025-07-07
 */
public class L199 {

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            Deque<TreeNode> queue = new ArrayDeque<>();
            if(root == null) {
                return new ArrayList<>();
            }
            List<Integer> res = new ArrayList<>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                int size = queue.size();
                for(int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    if(cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if(cur.right != null) {
                        queue.offer(cur.right);
                    }
                    if(i == size - 1) {
                        res.add(cur.val);
                    }
                }
            }
            return res;
        }
    }
}
