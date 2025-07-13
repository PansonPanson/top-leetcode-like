package top.panson.top100.matrix;

/**
 * @author Panson
 * @create 2025-07-13
 */
public class L048 {
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            // 对角线翻转
            for(int i = 0; i < n; i++) {
                for(int j = i; j < n; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }

            // 翻转每一行
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n / 2; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - 1 - j];
                    matrix[i][n - 1 - j] = tmp;
                }
            }
        }
    }
}
