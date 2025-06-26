package top.panson.top100.dp;

/**
 * @author Panson
 * @create 2025-06-26
 */
public class L070 {
    class Solution {

        public int climbStairs(int n) {

            if(n <= 2) {
                return n;
            }

            int pre_pre = 1;
            int pre = 2;
            int cur = 3;
            for(int i = 3; i <= n; i++) {
                cur = pre + pre_pre;
                pre_pre = pre;
                pre = cur;
            }
            return cur;
        }
    }
}
