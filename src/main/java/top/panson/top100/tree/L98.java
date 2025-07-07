package top.panson.top100.tree;

import top.panson.top100.commondata.TreeNode;

/**
 * @author Panson
 * @create 2025-07-07
 */
public class L98 {
    class Solution {

        long pre = Long.MIN_VALUE;

        public boolean isValidBST(TreeNode root) {
            if(root == null) {
                return true;
            }
            if(!isValidBST(root.left)) {
                return false;
            }
            if(pre >= root.val) {
                return false;
            }
            pre = root.val;

            return isValidBST(root.right);
        }
    }
}
