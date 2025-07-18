package top.panson.top100.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Panson
 * @create 2025-07-19
 */
public class L015 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int n = nums.length;
            if(n < 2) {
                return res;
            }


            Arrays.sort(nums);

            for(int i = 0; i < n - 2; i++) {
                // 去掉重复值
                if(i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int left = i + 1;
                int right = n - 1;

                while(left < right) {

                    int sum = nums[i] + nums[left] + nums[right];
                    if(sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                        // 添加了结果之后再去重
                        while(left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while(left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if(sum > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }

            return res;
        }
    }
}
