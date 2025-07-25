package top.panson.top100.array;

/**
 * @author Panson
 * @create 2025-07-17
 */
public class L238 {

    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            res[0] = 1;
            for(int i = 1; i < n; i++) {
                res[i] = res[i - 1] * nums[i - 1];
            }
            int post = 1;
            for(int i = n - 1; i >= 0; i--) {
                res[i] = res[i] * post;
                post = post * nums[i];
            }

            return res;
        }
    }
}
