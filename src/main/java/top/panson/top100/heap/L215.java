package top.panson.top100.heap;

import java.util.Random;

/**
 * @author Panson
 * @create 2025-07-01
 */
public class L215 {
    class Solution {

        Random random = new Random();
        public int findKthLargest(int[] nums, int k) {
            int n = nums.length;
            return quickSelect(nums, 0, n - 1, n - k);
        }

        public int quickSelect(int[] nums, int left, int right, int k) {
            if(left == right) {
                // 只有一个
                return nums[left];
            }
            int pivotIndex = partition(nums, left, right);
            if(pivotIndex == k) {
                return nums[pivotIndex];
            } else if(pivotIndex < k) {
                return quickSelect(nums, pivotIndex + 1, nums.length - 1, k);
            } else {
                return quickSelect(nums, left, pivotIndex - 1, k);
            }

        }


        public int partition(int[] nums, int left, int right) {
            int pivotIndex = left + random.nextInt(right - left + 1);

            swap(nums, right, pivotIndex);

            int pivot = nums[right];
            // j 指向待处理的下一个元素，j 左侧都是小于 pivot 的
            int j = left;
            // 将所有小于 pivot 的都放到左侧
            for(int i = left; i < right; i++) {
                if(nums[i] < pivot) {
                    swap(nums, i, j);
                    j++;
                }
            }
            swap(nums, j, right);
            return j;
        }


        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }


    }
}
