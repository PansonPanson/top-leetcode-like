package top.panson.top100.twopointer;

/**
 * @author Panson
 * @create 2025-07-19
 */
public class L283 {

    class Solution {
        public void moveZeroes(int[] nums) {
            // i 负责维护非 0 元素的目标位置
            int i = 0;
            int n = nums.length;
            for(int j = 0; j < n; j++) {
                // 遍历，把所有不为 0 的元素移动到 i 位置
                if(nums[j] != 0) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    i++;
                }
            }
        }
    }
}
