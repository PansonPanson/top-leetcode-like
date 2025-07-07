package top.panson.top100.tree;

import top.panson.top100.commondata.TreeNode;

/**
 * @author Panson
 * @create 2025-07-07
 */
public class L230 {
    class Solution {
        int res = -1;
        int step = 0;

        public int kthSmallest(TreeNode root, int k) {
            traverse(root, k);
            return res;
        }

        public void traverse(TreeNode root, int k) {
            if (root == null || step >= k) {
                return;
            }

            traverse(root.left, k); // 先访问左子树
            step++;
            if (step == k) {      // 访问当前节点，计数 +1
                res = root.val;
                return;             // 找到后立即返回
            }

            traverse(root.right, k); // 最后访问右子树
        }
    }
}
