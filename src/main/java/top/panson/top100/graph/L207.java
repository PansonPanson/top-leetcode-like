package top.panson.top100.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Panson
 * @create 2025-07-06
 */
public class L207 {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<List<Integer>> graph = new ArrayList<>();
            int[] inDegree = new int[numCourses];

            for(int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
            }

            // 构建图和入度表
            for(int[] edge : prerequisites) {
                int to = edge[0];
                int from = edge[1];
                graph.get(from).add(to);
                inDegree[to]++;

            }

            // 将所有入度为 0 的点入队
            Deque<Integer> queue = new ArrayDeque<>();
            for(int i = 0; i < numCourses; i++) {
                if(inDegree[i] == 0) {
                    queue.offer(i);
                }
            }

            int visited = 0;

            while(!queue.isEmpty()) {
                int cur = queue.poll();
                visited++;
                for(int next : graph.get(cur)) {
                    inDegree[next]--;
                    if(inDegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }

            return visited == numCourses;


        }
    }
}
