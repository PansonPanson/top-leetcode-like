package top.panson.top100.binarysearch;

/**
 * @author Panson
 * @create 2025-07-03
 */
public class L035 {

    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            // 相当于查找第一个大于等于 target 的元素下标
            while(left < right) {
                int mid = (left + right) / 2;
                if(nums[mid] == target) {
                    return mid;
                } else if(nums[mid] < target){
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
}
