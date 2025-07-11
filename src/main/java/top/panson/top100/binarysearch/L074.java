package top.panson.top100.binarysearch;

/**
 * @author Panson
 * @create 2025-07-03
 */
public class L074 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int left = 0;
            int m = matrix.length;
            int n = matrix[0].length;
            int right = m * n - 1;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                int val = matrix[mid / n][mid % n];
                if(val == target) {
                    return true;
                } else if(val < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }
    }
}
