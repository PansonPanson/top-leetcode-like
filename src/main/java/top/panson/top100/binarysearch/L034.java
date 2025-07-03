package top.panson.top100.binarysearch;

/**
 * @author Panson
 * @create 2025-07-03
 */
public class L034 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = searchLeft(nums, target, 0, nums.length);
            int right = searchRight(nums, target, 0, nums.length);
            return new int[]{left, right};
        }

        public int searchLeft(int[] nums, int target, int left, int right) {
            while(left < right) {
                int mid = (right - left) / 2  + left;
                if(nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left < nums.length && nums[left] == target ? left : -1;
        }

        public int searchRight(int[] nums, int target, int left, int right) {
            while(left < right) {
                int mid = (right - left) / 2  + left;

                if(nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left > 0 && nums[left - 1] == target ? left - 1 : -1;
        }
    }
}
