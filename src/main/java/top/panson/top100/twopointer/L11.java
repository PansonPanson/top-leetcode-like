package top.panson.top100.twopointer;

/**
 * @author Panson
 * @create 2025-07-19
 */
public class L11 {

    class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int max = 0;
            while(left < right) {
                max = Math.max(max, (right - left) *  Math.min(height[left], height[right]));

                if(height[left] > height[right]) {
                    right--;
                } else {
                    left++;
                }
            }
            return max;
        }
    }
}
