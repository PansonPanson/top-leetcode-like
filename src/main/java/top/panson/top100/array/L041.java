package top.panson.top100.array;

/**
 * @author Panson
 * @create 2025-07-19
 */
public class L041 {
    class Solution {

        /**
         * 标记法
         */
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;

            // 1. 将所有小于等于0或者大于n的数字设置为n+1，这些数字不可能是我们要找的第一个缺失的正整数
            for (int i = 0; i < n; i++) {
                if (nums[i] <= 0 || nums[i] > n) {
                    nums[i] = n + 1;
                }
            }

            // 2. 将每个数字放到它该在的位置上，即nums[i]应该在nums[nums[i] - 1]的位置
            for (int i = 0; i < n; i++) {
                // 我们只改变数的“符号”（正或负），不改变它的绝对值，而且我们在使用这个数前，都通过 Math.abs(nums[i]) 来恢复它原始的值。
                int num = Math.abs(nums[i]);
                if (num <= n && nums[num - 1] > 0) {
                    nums[num - 1] = -nums[num - 1]; // 将nums[num-1]标记为负，表示num已经出现过
                }
            }

            // 3. 找出第一个未标记为负的索引，索引+1就是缺失的第一个正整数
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }

            // 如果都标记为负，说明所有正整数都在数组中，返回n+1
            return n + 1;
        }
    }

}
