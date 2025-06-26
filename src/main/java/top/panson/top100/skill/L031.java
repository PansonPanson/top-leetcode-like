package top.panson.top100.skill;

/**
 * @author Panson
 * @create 2025-06-26
 */
public class L031 {
    class Solution {
        public void nextPermutation(int[] nums) {
            // 12321 -》 逆序遍历，找到开始下降的第一个数 A，再次逆序遍历， 查找第一个比A大的数B，交换AB，
            // 再将交换前 A 所在位置后续的数全部翻转,因为之前 A 之后的数都是降序的
            int n = nums.length;
            int p1 = -1;
            int p2 = -1;
            for(int i = n - 2; i >= 0; i--) {
                if(nums[i] < nums[i + 1]) {
                    p1 = i;

                    for(int j = n - 1; j > i; j--) {
                        if(nums[j] > nums[i]) {
                            p2 = j;
                            break;
                        }
                    }
                    break;
                }

            }
            if(p1 != -1) {
                swap(nums, p1, p2);
            }
            reverse(nums, p1);


        }

        public void swap(int[] nums, int p1, int p2) {
            int tmp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = tmp;
        }

        public void reverse(int[] nums, int p1) {
            int left = p1 + 1;
            int right = nums.length - 1;
            while(left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
    }
}
