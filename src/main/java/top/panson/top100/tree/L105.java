package top.panson.top100.tree;

import top.panson.top100.commondata.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2025-07-07
 */
public class L105 {

    class Solution {

        Map<Integer, Integer> map = new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for(int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }


        public TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
            if (preStart > preEnd) return null;
            TreeNode root = new TreeNode(preorder[preStart]);
            int leftLength = map.get(root.val) - inStart;
            root.left = build(preorder, inorder, preStart + 1, preStart + leftLength, inStart, inStart + leftLength - 1);
            root.right = build(preorder, inorder, preStart + leftLength + 1, preEnd, inStart + leftLength + 1, inEnd);
            return root;
        }


    }
}
