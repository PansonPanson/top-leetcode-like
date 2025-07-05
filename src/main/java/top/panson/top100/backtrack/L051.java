package top.panson.top100.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Panson
 * @create 2025-07-06
 */
public class L051 {
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> res = new ArrayList<>();
            char[][] board = new char[n][n];

            // 初始化棋盘
            for (char[] row : board) {
                Arrays.fill(row, '.');
            }

            backtrack(0, board, res);
            return res;
        }

        private void backtrack(int row, char[][] board, List<List<String>> res) {
            int n = board.length;
            if (row == n) {
                res.add(construct(board));
                return;
            }

            for (int col = 0; col < n; col++) {
                if (!isValid(board, row, col)) continue;

                board[row][col] = 'Q';     // 放皇后
                backtrack(row + 1, board, res);
                board[row][col] = '.';     // 撤销决策
            }
        }

        // 判断 (row, col) 位置是否安全
        private boolean isValid(char[][] board, int row, int col) {
            int n = board.length;

            // 同列
            for (int i = 0; i < row; i++) {
                if (board[i][col] == 'Q') return false;
            }

            // 左上对角线
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') return false;
            }

            // 右上对角线
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (board[i][j] == 'Q') return false;
            }

            return true;
        }

        // 构造结果
        private List<String> construct(char[][] board) {
            List<String> list = new ArrayList<>();
            for (char[] row : board) {
                list.add(new String(row));
            }
            return list;
        }
    }

}
