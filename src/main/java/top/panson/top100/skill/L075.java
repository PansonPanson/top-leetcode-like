package top.panson.top100.skill;

/**
 * @author Panson
 * @create 2025-06-24
 */
public class L075 {

    public class Solution {
        public void sortColors(int[] nums) {
            int zero = 0;               // zero: 当前 0 应该放置的位置
            int two = nums.length - 1;  // two: 当前 2 应该放置的位置
            int i = 0;

            while (i <= two) {
                if (nums[i] == 0) {
                    swap(nums, i, zero);
                    zero++;
                    i++;  // 因为 nums[i] 是 0，换过来的是已处理过的，i 可以 ++
                } else if (nums[i] == 2) {
                    swap(nums, i, two);
                    two--;
                    // i 不加，因为换过来的可能是 0 或 1，需再判断
                } else {
                    i++;  // nums[i] == 1，直接跳过
                }
            }
        }

        private void swap(int[] nums, int a, int b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }
}
