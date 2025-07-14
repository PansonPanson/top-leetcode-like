package top.panson.top100.matrix;

/**
 * @author Panson
 * @create 2025-07-13
 */
public class L240 {

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int i = 0;
            int j = n - 1;
            // 从左上角，两个方向都是增加，不太合适
            // 从右上角，往左变小，往下变大
            // 这个搜索路径是有剪枝性质的，不会遗漏任何可能值。
            // 每次比较后，有且仅有一个分支可能存在目标值。
            // 一旦走错方向，目标值已经被“剪掉”，不可能在回头路径中找到。
            // 举个例子：
            // 假设你当前在 (i, j) 这个位置：
            // 如果 matrix[i][j] > target，说明该列的下方元素都更大，所以排除整列，向左走（j--）。
            // 如果 matrix[i][j] < target，说明该行的左边元素都更小，所以排除整行，向下走（i++）。
            while (i >= 0 && i < m && j >= 0 && j < n) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] > target) {
                    j--;
                } else {
                    i++;
                }
            }
            return false;
        }
    }
}
