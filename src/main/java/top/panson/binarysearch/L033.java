package top.panson.binarysearch;

/**
 * @author Panson
 * @create 2025-06-23
 */
public class L033 {
    class Solution {
        public int search(int[] nums, int target) {
            // 二分，左边最小值大于右边最大值，分段升序
            int n = nums.length;
            int left = 0;
            int right = n - 1;
            return search( nums, left, right, target);
        }

        public int search(int[] nums, int left, int right,  int target) {
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] == target) {
                    return mid;
                } else if(nums[left] <= nums[mid]) {
                    // 左边有序
                    if(nums[left] <= target && target < nums[mid]) {
                        // 说明在左边，缩小右边界
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    // 右边有序
                    if(nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}
