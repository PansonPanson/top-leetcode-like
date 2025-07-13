package top.panson.top100.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panson
 * @create 2025-07-13
 */
public class L54 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int top = 0;
            int bottom = m - 1;
            int left = 0;
            int right = n - 1;
            int count = 0;
            List<Integer> res = new ArrayList<>();
            int size = m * n;
            while(count < size) {
                for(int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                    count++;
                }
                top++;
                for(int i = top; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                    count++;
                }
                right--;
                for(int i = right; i >= left && count < size; i--) {
                    res.add(matrix[bottom][i]);
                    count++;
                }
                bottom--;
                for(int i = bottom; i >= top && count < size; i--) {
                    res.add(matrix[i][left]);
                    count++;
                }
                left++;
            }
            return res;
        }
    }
}
