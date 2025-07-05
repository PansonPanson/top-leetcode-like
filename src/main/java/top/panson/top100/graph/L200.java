package top.panson.top100.graph;

/**
 * @author Panson
 * @create 2025-07-06
 */
public class L200 {
    class Solution {
        public int numIslands(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int count = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == '1') {
                        count++;
                        fillZero(grid, i, j);
                    }
                }
            }
            return count;
        }

        public void fillZero(char[][] grid, int i, int j) {
            int m = grid.length;
            int n = grid[0].length;
            if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
                return;
            }
            grid[i][j] = '0';
            fillZero(grid, i - 1, j);
            fillZero(grid, i + 1, j);
            fillZero(grid, i, j - 1);
            fillZero(grid, i, j + 1);
        }
    }
}
