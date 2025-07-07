package top.panson.top100.tree;

import top.panson.top100.commondata.TreeNode;

/**
 * @author Panson
 * @create 2025-07-07
 */
public class L114 {

    class Solution {

        TreeNode pre = null;
        public void flatten(TreeNode root) {

            traverse(root);

        }

        public void traverse(TreeNode root) {
            if(root == null) {
                return;
            }


            traverse(root.right);
            traverse(root.left);

            root.right = pre;
            pre = root;
            root.left = null;
        }
    }
}
