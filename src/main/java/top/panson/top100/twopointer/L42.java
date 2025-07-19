package top.panson.top100.twopointer;

/**
 * @author Panson
 * @create 2025-07-19
 */
public class L42 {
    class Solution {
        public int trap(int[] height) {
            if (height.length == 0) {
                return 0;
            }
            int n = height.length;
            int res = 0;
            int[] l_max = new int[n];
            int[] r_max = new int[n];
            // 初始化 base case
            l_max[0] = height[0];
            r_max[n - 1] = height[n - 1];
            // 如果自己就是最高的话，
            // l_max == r_max == height[i]
            for (int i = 1; i < n; i++) {
                l_max[i] = Math.max(l_max[i - 1], height[i]);
            }
            for (int i = n - 2; i >= 0; i--) {
                r_max[i] = Math.max(r_max[i + 1], height[i]);
            }


            for (int i = 1; i < n - 1; i++) {
                res += Math.min(l_max[i], r_max[i]) - height[i];
            }
            return res;
        }
    }
}
