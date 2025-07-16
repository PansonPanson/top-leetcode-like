package top.panson.top100.array;

/**
 * @author Panson
 * @create 2025-07-16
 */
public class L189 {

    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k = k % n;
            // 证明 A + B  ->  B + A;
            // 反转整个数组
            // reverse(B) + reverse(A);
            reverse(nums, 0, n - 1);
            // 反转前k个元素
            // B + reverse(A);
            reverse(nums, 0, k - 1);
            // 反转剩余元素
            // B + A
            reverse(nums, k, n - 1);
        }

        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }
}
