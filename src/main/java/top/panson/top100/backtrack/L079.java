package top.panson.top100.backtrack;

/**
 * @author Panson
 * @create 2025-07-05
 */
public class L079 {
    class Solution {
        public boolean exist(char[][] board, String word) {
            boolean[][] visited = new boolean[board.length][board[0].length];
            int m = board.length;
            int n = board[0].length;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    boolean exist = traverse(board, word, visited, 0, i, j);
                    if(exist) {
                        return true;
                    }
                }
            }
            return false;
        }


        public boolean traverse(char[][] board, String word, boolean[][] visited, int index, int i, int j) {
            if(index == word.length()) {
                return true;
            }
            int m = board.length;
            int n = board[0].length;
            if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(index)) {
                return false;
            }

            visited[i][j] = true;

            boolean exist = (traverse(board, word, visited, index + 1, i + 1, j)
                    || traverse(board, word, visited, index + 1, i, j + 1)
                    || traverse(board, word, visited, index + 1, i - 1, j)
                    || traverse(board, word, visited, index + 1, i, j - 1)
            );

            visited[i][j] = false;

            return exist;
        }
    }
}
