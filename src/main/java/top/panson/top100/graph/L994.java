package top.panson.top100.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Panson
 * @create 2025-07-06
 */
public class L994 {
    class Solution {
        public int orangesRotting(int[][] grid) {
            Queue<int[]> queue = new ArrayDeque<>();
            int step = 0;
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == 2) {
                        queue.offer(new int[]{i,j});
                    }
                }
            }

            int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

            while(!queue.isEmpty()) {
                int size = queue.size();
                for(int i = 0; i < size; i++) {
                    int[] cur  = queue.poll();
                    for(int[] dir : dirs) {
                        int m = cur[0] + dir[0];
                        int n = cur[1] + dir[1];
                        if(m >= 0 && m < grid.length && n >= 0 && n < grid[0].length && grid[m][n] == 1) {
                            grid[m][n] = 2;
                            queue.offer(new int[]{m, n});
                        }
                    }
                }
                step++;
            }

            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == 1) {
                        return -1;
                    }
                }
            }
            return step == 0 ? step : step - 1;
        }
    }
}
